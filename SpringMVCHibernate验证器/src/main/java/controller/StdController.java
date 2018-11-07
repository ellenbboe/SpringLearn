package controller;

import beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StdController {
    @RequestMapping(value = "/addstudent",method = RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("addStudent","command",new Student());
    }

    @ModelAttribute("student")
    public Student createStudent(){
        return new Student();
    }
    
    @RequestMapping(value = "/addstudent",method = RequestMethod.POST)
    public String addstudent(@ModelAttribute("student") @Validated Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "addStudent";
        }
        model.addAttribute("name",student.getName());
        model.addAttribute("id",student.getId());
        model.addAttribute("age",student.getAge());
        return "result";
    }
}
