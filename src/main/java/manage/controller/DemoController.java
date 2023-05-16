package manage.controller;

import io.swagger.annotations.ApiOperation;
import manage.pojo.Admin;
import manage.service.ItemService;
import manage.service.DemoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class DemoController {
    @Autowired
    DemoService demoService;
    @Autowired
    ItemService itemService;

    @ApiOperation("更新后台首页数据")
    @ResponseBody
    @GetMapping("/refreshIndex")
    public String[] refreshIndex(@RequestParam("adminId") String adminId) {
        String[] indexData=itemService.getIndexData(Integer.parseInt(adminId));
        return indexData;
    }

    @ApiOperation("跳转到前台首页轮播")
    @GetMapping("/toRollAd")
    public String toRollAd() {
        return "rollAd";
    }

    @ApiOperation("退出管理员账号")
    @RequiresAuthentication
    @GetMapping("/logout")
    public String logout() {
        //在这里执行退出系统前需要清空的数据
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        return "toLogin";
    }

    @ApiOperation("跳转到后台首页")
    @GetMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @ApiOperation("跳转到登录管理员页面")
    @GetMapping("/toLogin")
    public String toLogin() {
        return "toLogin";
    }

    @ApiOperation("根据账号密码进行管理员登录")
    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpSession session) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //执行登录方法
            subject.login(token);
            Admin admin = itemService.queryUserByName(username);
            session.setAttribute("theAdmin", admin);
            return "index";
        } catch (UnknownAccountException e) {
            //用户不存在
            model.addAttribute("msg", "用户名错误");
            return "/toLogin";
        } catch (IncorrectCredentialsException e) {
            //密码错误
            model.addAttribute("msg", "密码错误");
            return "/toLogin";
        }
    }

    @ApiOperation("根路径，跳转至管理员登录页面")
    @GetMapping("/")
    public String demo() {
        return "/toLogin";
    }

    @ApiOperation("提示没有权限访问")
    @ResponseBody
    @GetMapping("/unAuthorized")
    public String unAuthorized() {
        return "未经授权，不能访问此页面";
    }
}
