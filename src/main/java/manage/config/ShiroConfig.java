package manage.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
        anon    无需认证就可以访问
        authc   必须认证了才能访问
        user    必须拥有 记住我 才能用
        perms   拥有对某个资源的权限才能访问
        role    拥有某个角色权限才能访问
        */
        //拦截顺序是有要求的，put()的顺序变化会引起拦截失效
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权，没有授权会跳转到未授权页面
        filterMap.put("/admin/**", "roles[admin]");
        filterMap.put("/item/**", "roles[admin]");
        filterMap.put("/ads/**", "roles[admin]");

        //拦截，没登录会跳转到登录页面
        filterMap.put("/admin/*", "authc");

        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthorized");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    //DefaultWebSecurityManage:2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象，需要自定义类:1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //ShiroDialect，用来整合thymeleaf和shiro
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
