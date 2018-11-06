package pers.kim.administrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.kim.administrator.pojo.ErrorMessage;
import pers.kim.administrator.pojo.User;
import pers.kim.administrator.service.UserManager;

import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUser() {
        return userManager.findAllUser();
    }

    @ExceptionHandler(value = PersistenceException.class)
    public Map<String, ErrorMessage> handlerPerdidtenceException(Exception e) {
        Map<String, ErrorMessage> map = new HashMap<>();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(500);
        errorMessage.setReson("pers.kim.administrator.service error!");
        map.put("error", errorMessage);
        return map;
    }

}
