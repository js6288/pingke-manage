package manage.controller;


import io.swagger.annotations.ApiOperation;
import manage.mapper.AdObjectMapper;
import manage.pojo.AdObject;
import manage.pojo.Admin;
import manage.pojo.RollAd;
import manage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdController {

    @Autowired
    AdObjectMapper adObjectMapper;

    @Autowired
    ItemService itemService;

    @ApiOperation("修改广告轮播图")
    @ResponseBody
    @PostMapping("/rollAd/changeRollAd")
    public void changeRollAd(String imgId,String imgSrc) {
        itemService.changeRollAd(imgId,imgSrc);
    }

    @ApiOperation("获得所有广告轮播图")
    @ResponseBody
    @GetMapping("/rollAd/getRollAds")
    public List getRollAds() {
        List<RollAd> rollAds = itemService.getRollAds();
        return rollAds;
    }

    @ApiOperation("跳转至广告管理页面")
    @GetMapping("/ads/adsManage")
    public String adsManage(){
        return "ads";
    }

    @ApiOperation("修改前台广告栏内容")
    @RequestMapping(value = "/ads/editAd",method = RequestMethod.PUT)
    @ResponseBody
    public String editAd(
            @RequestParam("adId") String adIdString,
            @RequestParam("adName") String adName,
            @RequestParam("adIntroduce") String adIntroduce,
            @RequestParam("adSrc") String adSrc,
            HttpServletRequest request){
        int adId = Integer.parseInt(adIdString);
        Integer adminId = ((Admin) (request.getSession().getAttribute("theAdmin"))).getAdminId();
        adObjectMapper.updateByPrimaryKey(new AdObject(adId,adName,adSrc,adIntroduce,adminId));
        return "";
    }

    @ApiOperation("获取广告栏信息")
    @RequestMapping(value = "/ads/getAds",method = RequestMethod.GET)
    @ResponseBody
    public List getAds(){
        List<AdObject> adObjects = adObjectMapper.selectByExample(null);
        return adObjects;
    }

    @ApiOperation("根据ID获取广告对象广告对象AdObject")
    @RequestMapping(value = "/ads/getAdById",method = RequestMethod.GET)
    @ResponseBody
    public AdObject getAdById(@RequestParam("") int id){
        AdObject adObject=adObjectMapper.selectByPrimaryKey(id);
        return adObject;
    }

}
