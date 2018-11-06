package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 7/31/2018 10:02 AM
 **/
@RestController
@Validated // Bean validation 1.1 开启方法级校验
public class UserController {


//    @RequestMapping("/register")
//    public Object register(@Valid User user, BindingResult result) {
//        System.err.println(user);
//        return user;
//    }

    @RequestMapping("/register")
    public @NotNull Object register(@NotNull User user) {
        System.err.println(user);
        return user;
    }

}
