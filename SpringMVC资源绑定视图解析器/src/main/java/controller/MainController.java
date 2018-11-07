package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("message","你好");
        return "hello";
    }
}
