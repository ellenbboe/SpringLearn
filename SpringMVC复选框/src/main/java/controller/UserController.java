package controller;

import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView user(){
        return new ModelAndView("user","command",new User());
    }
@RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("SpringWeb")User user, ModelMap modelMap){
        modelMap.addAttribute("username",user.getUsername());
        modelMap.addAttribute("address",user.getAddress());
    System.out.println(user.getAddress());
        modelMap.addAttribute("password",user.getPassword());
        modelMap.addAttribute("recivepaper",user.getRecivepaper());
        return "userlist";
    }
}
