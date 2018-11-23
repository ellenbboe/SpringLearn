package controller;
/*
@Controller表明这个类是一个控制器在处理具有模式映射的@RequestMapping请求。这里使用 ‘/’, 它被作为默认的控制器。方法newRegistration是相当简单的，注解为@ RequestMethod.GET服务默认是GET请求，使用模型对象，以服务为形式的数据，并呈现包含空白表单的网页。
方法initializeSections, initializeCountries & initializeSubjects是简单地创建请求级别的对象，其值在视图/JSP中将被使用。
方法saveRegistration 标注有@ RequestMethod.POST，并将处理表单提交POST请求。注意本方法的参数和它们的顺序。 @Valid要求spring来验证相关的对象(学生)。
BindingResult包含此验证，并可能在此验证过程中发生(产生)任何错误的结果。请注意，BindingResult一定要在之后立即生效对象，否则spring将无法验证并且将一个异常抛出。
 */
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
    //默认get处理
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap modelMap){
        Student student = new Student();
        modelMap.addAttribute("student",student);
        return "enroll";
    }
    /*
     * This method will be called on form submission, handling POST request
     * It also validates the user input
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveRegistration(@Valid Student student, BindingResult bindingResult,ModelMap modelMap)
    {
        if(bindingResult.hasErrors())
        {
            return "enroll";
        }
        modelMap.addAttribute("success","Dear"+student.getFirstName()+",your Registration completed successfully");
        return "success";
    }

    @ModelAttribute("sections")
    public List<String> initializeSections(){
        List<String> sections = new ArrayList<String>();
        sections.add("graduate");
        sections.add("post graduate");
        sections.add("research");
        return sections;
    }

    @ModelAttribute("countries")
    public List<String> initializeCountry(){
        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CN");
        countries.add("DSA");
        countries.add("RA");
        countries.add("IND");
        return countries;
    }
    @ModelAttribute("subjects")
    public List<String> initializeSubjects() {

        List<String> subjects = new ArrayList<String>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }



}
