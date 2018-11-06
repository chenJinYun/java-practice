package pers.kim.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.kim.merchant.pojo.ErrorMessage;
import pers.kim.merchant.pojo.User;
import pers.kim.merchant.service.UserManager;


import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Create on 7/30/2018
 *
 * @Author Kim
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserManager userManager;

    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(@RequestParam(value="path",required=false)MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(dir);
        return fileName;
    }
    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userManager.addUser(user);
    }

    @ExceptionHandler(value = PersistenceException.class)
    public Map<String, ErrorMessage> handlerPerdidtenceException(Exception e) {
        Map<String, ErrorMessage> map = new HashMap<>();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(500);
        errorMessage.setReson("service error!");
        map.put("error", errorMessage);
        return map;
    }

}
