package pers.kim.mvc_interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Create on 7/25/2018
 *
 * @Author Kim
 */
@SessionAttributes(value = {"name"})
@Controller
@RequestMapping("list")
public class InterceptorProject {
    private static Map<String,String> map=new HashMap<>();
    static {
        map.put("name","kim");
        map.put("age","18");
        map.put("sex","女");
        map.put("address","gz");
    }
    @GetMapping("login")
    public String login(String name,String password, Model model) {
        if(name.equals("kim")&&password.equals("123")){
            model.addAttribute("name", name);
            return "forward:findAllList";
        }
        return "redirect:/jsp/login";

    }

    @GetMapping("findAllList")
    public String findAllList(Model model) {
        model.addAttribute("list",map);
        return "/jsp/list";
    }
    @GetMapping("deleteList")
    public String deleteList(Model model){
        map.remove("address");
        return "forward:findAllList";
    }
}
