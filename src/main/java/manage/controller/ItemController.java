package manage.controller;

import io.swagger.annotations.ApiOperation;
import manage.pojo.Admin;
import manage.pojo.Item;
import manage.pojo.RollAd;
import manage.service.ItemService;
import manage.utils.MultipartFileTransferToFileUtil;
import manage.utils.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class ItemController {

    @Value("${spring.servlet.multipart.max-file-size}")
    String maxSize;

    @Autowired
    ItemService itemService;

    @Autowired
    UploadFileUtil upl;

    @ApiOperation("上交作品")
    @RequestMapping(value = "/item/upLoadWork", method = RequestMethod.POST)
    public String upLoadWork(
            @RequestParam(value = "multipartFile", required = false) MultipartFile multipartFile,
            @RequestParam("itemToUploadId") int itemId,
            HttpServletRequest request,
            Model model
    ) {
        if (multipartFile.getSize() == 0) {
            maxSize=maxSize.replace("MB","");
            double maxSizeInt=Double.parseDouble(maxSize)*1024*1024;
            model.addAttribute("maxSize",maxSizeInt);
            model.addAttribute("uploadMsg", "你未提交文件");
            return "toBeFinished";
        } else {
            maxSize=maxSize.replace("MB","");
            double maxSizeInt=Double.parseDouble(maxSize)*1024*1024;
            model.addAttribute("maxSize",maxSizeInt);
            MultipartFileTransferToFileUtil mul = new MultipartFileTransferToFileUtil();
            File file = mul.transferToFile(multipartFile);
            String downloadAddress = upl.upload(file);
            int adminId = ((Admin) (request.getSession().getAttribute("theAdmin"))).getAdminId();
            itemService.updateFinshedInfo(itemId, adminId, downloadAddress);
            model.addAttribute("uploadMsg", "上传成功");
            return "toBeFinished";
        }
    }

    @ApiOperation("获取该管理员未完成任务Json数据")
    @ResponseBody
    @RequestMapping(value = "/item/toBeFinished/{adminId}", method = RequestMethod.GET)
    public List toBeFinishedJson(@PathVariable("adminId") String adminId, Model model) {
        List<Item> toBeFinishedItems = itemService.toBeFinishedByAdminId(adminId);
        for(Item item:toBeFinishedItems){
            item.setFormattedEndTime();
        }
        return toBeFinishedItems;
    }

    @ApiOperation("获得所有待处理的用户请求")
    @RequestMapping(value = "/item/toBeFinished", method = RequestMethod.GET)
    public String toBeFinished(Model model) {
        maxSize=maxSize.replace("MB","");
        double maxSizeInt=Double.parseDouble(maxSize)*1024*1024;
        model.addAttribute("maxSize",maxSizeInt);
        return "toBeFinished";
    }

    @ApiOperation("获取管理员完成工作信息")
    @ResponseBody
    @RequestMapping(value = "/item/getFinishedItemsByAdminId", method = RequestMethod.GET)
    public List getFinishedItemsByAdminId(@RequestParam("adminId") String adminId) {
        List<Item> finishedItems = itemService.getFinishedItemsByAdminId(adminId);
        //得到格式化后的FinishedTime，用于在前端显示
        for (Item item:finishedItems){
            item.setFormattedFinishedTime();
        }
        return finishedItems;
    }

    @ApiOperation("拒绝用户的请求")
    @ResponseBody
    @RequestMapping(value = "/item/refuseItem", method = RequestMethod.PUT)
    public String refuseItem(@RequestParam("itemId") String itemId,
                             @RequestParam("adminId") String adminId,
                             @RequestParam("refuseReason") String refuseReason) {
        itemService.refuseItem(itemId, adminId, refuseReason);
        return "成功拒绝用户申请。";
    }

    @ApiOperation("通过ID获得Item")
    @ResponseBody
    @RequestMapping(value = "/item/getItemById", method = RequestMethod.GET)
    public Item getItemById(@RequestParam(value = "id") String id) {
        System.out.println("idddddd="+id);
        Item item = itemService.queryItemById(Integer.parseInt(id));
        return item;
    }

    @ApiOperation("接受用户的请求，开始加工")
    @ResponseBody
    @RequestMapping(value = "/item/acceptItem", method = RequestMethod.PUT)
    public String acceptItem(@RequestParam(value = "itemId") String itemId, HttpServletRequest request) {
        Admin theAdmin = (Admin) request.getSession().getAttribute("theAdmin");
        String adminId = theAdmin.getAdminId().toString();
        itemService.acceptItem(itemId, adminId);
        return "你已经成功接受该项目^_^";
    }
}
