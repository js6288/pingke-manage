package manage.config;

import manage.pojo.Admin;
import manage.service.ItemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    ItemService adminService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取认证时传递的参数admin
        Subject subject = SecurityUtils.getSubject();
        Admin currentAdmin = (Admin) subject.getPrincipal();
        //设置当前用户的权限，这里用数据库读取（数据库中刚好存储的是user:add、user:update...）
        info.addRole("admin");

        //这个Session是shiro的接口，不是HttpSession
        Session session = subject.getSession();
        //放在shiro的Session中，可以在前端获取
        session.setAttribute("loginAdmin", currentAdmin);

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Admin admin = adminService.queryUserByName(token.getUsername());
        if (admin == null) {
            //返回UnknownAccountException
            return null;
        }
        //返回IncorrectCredentialsException
        //这里第一个参数Principal，将admin对象传入，可以在上面的授权方法中用getPrincipal()得到
        return new SimpleAuthenticationInfo(admin, admin.getPassword(), "");
    }
}
