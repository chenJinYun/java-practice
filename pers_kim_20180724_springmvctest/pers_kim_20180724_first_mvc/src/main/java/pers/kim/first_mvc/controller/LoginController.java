package pers.kim.first_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kim.first_mvc.pojo.UserPojo;
import pers.kim.first_mvc.service.UserServiceImpl;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
public class LoginController {
    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(String name,String password){
        UserPojo userPojo=new UserPojo(name,password,"",0);
        UserServiceImpl userService=new UserServiceImpl();
        UserPojo resUser=userService.findUser(userPojo);
        if(resUser!=null){
            return resUser.getName();
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public String register(String name,String password,String rpassword,int age){
        UserPojo userPojo=new UserPojo(name,password,rpassword,age);
        UserServiceImpl userService=new UserServiceImpl();
        int res=0;
        res=userService.insertUser(userPojo);
        if(res>0){
            return "success";
        }
        return "fail";
    }
}
