package controller;

import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView user(){
        User user = new User();
        user.setFavorites((new String[]{"Spring MVC","Struts 2"}));
        user.setGender("M");
        ModelAndView modelAndView = new ModelAndView("user","command",user);
        return modelAndView;
    }
@RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("SpringWeb") User user, ModelMap modelMap){

        modelMap.addAttribute("username",user.getUsername());
        modelMap.addAttribute("address",user.getAddress());
        modelMap.addAttribute("password",user.getPassword());
        modelMap.addAttribute("recivepaper",user.getRecivepaper());
        modelMap.addAttribute("favorites",user.getFavorites());
        modelMap.addAttribute("gender",user.getGender());
        modelMap.addAttribute("lucknumber",user.getLucknumber());
        modelMap.addAttribute("country",user.getCountry());
        modelMap.addAttribute("skills",user.getSkills());

        return "userlist";
    }
    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList()
    {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Spring Boot");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Hadoop");
        return webFrameworkList;
    }
    @ModelAttribute("numberlist")
    public List<String> getnumberlist()
    {
        List<String> numberList = new ArrayList<String>();
        numberList.add("1");
        numberList.add("2");
        numberList.add("3");
        numberList.add("4");
        return numberList;
    }
    @ModelAttribute("countrylist")
    public List<String> getcountrylist(){
        List<String> country = new ArrayList<String>();
        country.add("北京");
        country.add("南京");
        country.add("东京");
        country.add("北海");
        country.add("西天");
        country.add("北上");
        return country;
    }

    @ModelAttribute("skilllist")
   public Map<String,String> getskills(){
        Map<String,String> skills = new HashMap<String,String>();
       skills.put("Hibernate", "Hibernate");
       skills.put("Spring", "Spring");
       skills.put("Apache Hadoop", "Apache Hadoop");
       skills.put("Struts", "Struts");
       return skills;
   }
}
