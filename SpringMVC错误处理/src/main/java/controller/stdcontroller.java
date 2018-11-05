package controller;

import beans.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class stdcontroller {

    @Autowired
    @Qualifier("stdv")
    private Validator validator;


    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }


    @ModelAttribute("student")
    public student createStudentModel() {
        return new student();
    }



    @RequestMapping(value = "/addstudent",method = RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("addstudent","command",new student());
    }


    @RequestMapping(value = "/addstudent",method = RequestMethod.POST)
    public String addstudent(@ModelAttribute("student") @Validated student student, BindingResult bindingResult, ModelMap modelMap){

        if (bindingResult.hasErrors()) {
            return "addstudent";
        }
        modelMap.addAttribute("name",student.getName());
        modelMap.addAttribute("id",student.getId());
        modelMap.addAttribute("age",student.getAge());
        return "result";
    }



    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
