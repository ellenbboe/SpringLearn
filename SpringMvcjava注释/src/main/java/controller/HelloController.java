package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayhello(ModelMap modelMap){
        modelMap.addAttribute("greeting","hellopage");
        return "welcome";
    }

    @RequestMapping(value = "/helloagain",method = RequestMethod.GET)
    public String sayhelloagaiin(ModelMap modelMap){
        modelMap.addAttribute("greeting","helloagainpage");
        return "welcome";
    }

}
