package cn.jiyun;

import cn.jiyun.pojo.User;
import cn.jiyun.pojo.Usr;
import cn.jiyun.service.UserService;
import cn.jiyun.service.UsrService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.lang.model.element.VariableElement;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    UsrService usrService;
    @Autowired
    UserService userService;


    @Test
    void contextLoads() {


       // Usr usr = usrService.queryUsrByName("111");
        User user = userService.queryUsrByName("111");

        System.out.println(user.toString());

    }

}
