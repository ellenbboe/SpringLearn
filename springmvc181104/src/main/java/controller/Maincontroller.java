package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Maincontroller{
    @RequestMapping(value = "/",method = RequestMethod.GET)
        public String index(){
            return "index";
        }
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
        }
}
