package cn.jiyun.config;

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

   //shiroFilterFactoryBean 3
   @Bean
   public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
       ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
       //设置安全管理器
       bean.setSecurityManager(defaultWebSecurityManager);

       //添加shiro的内置过滤器
        /*
            anon: 无需认证就可访问
            authc：必须认证才能访问
            user：必须拥有记住我功能才能访问
            perms: 拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
       */     //需要过滤的东西           //这里的Map是链式的
       Map<String, String> filterMap = new LinkedHashMap<>();
      //filterMap.put("/user/add","authc");  //->此时再访问add，update页面会被拦截 会跳转到自定义的login 页面
      //filterMap.put("/user/update","authc");

       //授权
       filterMap.put("/user/add","perms[user:add]");//加上这个以后 虽然登陆了账号，但是再点击会报401 正常情况会跳到未授权页面
       //授权
       filterMap.put("/user/update","perms[user:update]");//加上这个以后 虽然登陆了账号，但是再点击会报401 正常情况会跳到未授权页面


       //设置通配符 拦截符合路径的
      filterMap.put("/user/*","authc");

       //设置过滤
       bean.setFilterChainDefinitionMap(filterMap);

       //设置登录的请求
      bean.setLoginUrl("/toLogin");

      //未授权页面
      bean.setUnauthorizedUrl("/noauth");

       return bean;
   }


   //DafaultwebSecurityManager 2
   @Bean(name="securityManager")
   public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
       DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
       //关联UserRealm
       securityManager.setRealm(userRealm);

       return securityManager;
   }

   //创建 realm 对象   .需要自定义类 1
   @Bean(name = "userRealm")
   public UserRealm userRealm(){


       return  new UserRealm();
   }

    //整合thymeleaf ShiroDialect设置方言
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}
