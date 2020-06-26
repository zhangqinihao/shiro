package cn.jiyun.config;

import cn.jiyun.pojo.User;
import cn.jiyun.service.UserService;
import cn.jiyun.service.UsrService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


//自定义的UserRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UsrService usrService;
    @Autowired
    UserService userService;



    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //设置权限
        info.addStringPermission("user:add");
        //获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();

        User currentUser = (User) subject.getPrincipal();

        //设置用户权限
        info.addStringPermission(currentUser.getPrams());

        return info;
    }



    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");

       //伪造用户名 ，密码
      /*  String name="root";
        String password="123456";*/


        //连接真实的数据库
        UsernamePasswordToken userToken=(UsernamePasswordToken)token;
       /* if(!userToken.getUsername().equals(name)){
            return  null;    //抛出MyController的用户名不存在异常
        }*/

       /* Usr usr = usrService.queryUsrByName(userToken.getUsername());
        if(usr==null){
            return  null;
        }*/


        User user = userService.queryUsrByName(userToken.getUsername());
        if(user==null){
            return  null;
        }

        //整合了shiro thymeleaf 之后
        //获取当前用户
        Subject curentsubject= SecurityUtils.getSubject();
        Session session = curentsubject.getSession();
        session.setAttribute("loginUser",user);

        //密码认证 shiro做
      //  return new SimpleAuthenticationInfo("",userToken.getPassword(),"");
        //配置Principal
        return new SimpleAuthenticationInfo(user,userToken.getPassword(),"");
    }
}
