package controller;

import beans.student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class stdcontroller {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/std",method = RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("student","command",new student());
    }
    @RequestMapping(value = "/addstudent",method = RequestMethod.POST)
    public String addstudent(@ModelAttribute("SpringWeb")student student, ModelMap modelMap){
        modelMap.addAttribute("name",student.getName());
        modelMap.addAttribute("id",student.getId());
        modelMap.addAttribute("age",student.getAge());
        return "result";
    }
}
