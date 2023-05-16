package manage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import manage.pojo.Admin;
import manage.pojo.Item;
import manage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    ItemService itemService;

    @ApiOperation("获取本管理员已完成项目")
    @GetMapping("/admin/finished/{pageNum}")
    public String finished(@PathVariable(value = "pageNum") Integer pageNum, Model model, HttpServletRequest request){
        PageHelper.startPage(pageNum, 5);
        List<Item> itemsFinished = itemService.queryFinishedItemsByAdminId(
                ((Admin)request.getSession().getAttribute("theAdmin")).getAdminId()
        );
        PageInfo pageInfo = new PageInfo(itemsFinished, 5);
        model.addAttribute(pageInfo);
        int[] pageNums=new int[5];
        for(int i=0;i<pageInfo.getPages();i++){
            pageNums[i]=pageInfo.getNavigatepageNums()[i];
        }
        model.addAttribute("pages",pageNums);
        return "finished";
    }

    @ApiOperation("获取所有未处理的请求")
    @GetMapping("/admin/toBeSolved/{pageNum}")
    public String toBeSolved(@PathVariable(value = "pageNum") Integer pageNum, Model model){
        PageHelper.startPage(pageNum, 5);
        List<Item> itemsTobeSolved = itemService.queryAllItemsToBesolved();
        PageInfo pageInfo = new PageInfo(itemsTobeSolved, 5);
        model.addAttribute(pageInfo);
        int[] pageNums=new int[5];
        for(int i=0;i<5;i++){
            pageNums[i]=pageInfo.getNavigatepageNums()[i];
        }
        model.addAttribute("pages",pageNums);
        return "tobesolved";
    }

    @ApiOperation("获得待处理用户请求的Json数据")
    @ResponseBody
    @GetMapping("/admin/toBeSolvedJson/{pageNum}")
    public PageInfo toBeSolvedJson(@PathVariable(value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 5);
        List<Item> itemsTobeSolved = itemService.queryAllItemsToBesolved();
        for(Item item:itemsTobeSolved){
            item.setFormattedCreateTime();
            item.setFormattedEndTime();
        }
        PageInfo pageInfo = new PageInfo(itemsTobeSolved, 5);
        return pageInfo;
    }

    @ApiOperation("获得该管理员未完成任务的Json数据")
    @ResponseBody
    @GetMapping("/admin/toBeFinishedJson/{adminId}")
    public PageInfo toBeFinishedJson(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @PathVariable(value = "adminId") String adminId, Model model){
        PageHelper.startPage(pageNum, 5);
        List<Item> itemsUnfinished = itemService.queryUnfinishedItemsByAdminId(Integer.parseInt(adminId));
        PageInfo pageInfo = new PageInfo(itemsUnfinished, 5);
        model.addAttribute(pageInfo);
        return pageInfo;
    }

    @ApiOperation("获得该管理员已完成任务的Json数据")
    @ResponseBody
    @GetMapping("/admin/finishedJson/{adminId}")
    public PageInfo finishedJson(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @PathVariable(value = "adminId") String adminId){
        PageHelper.startPage(pageNum, 5);
        List<Item> itemsFinished = itemService.queryFinishedItemsByAdminId(Integer.parseInt(adminId));
        PageInfo pageInfo = new PageInfo(itemsFinished, 5);
        return pageInfo;
    }

}
