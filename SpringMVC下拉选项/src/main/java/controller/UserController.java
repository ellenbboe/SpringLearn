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
    public Map<String,String> getcountrylist(){
        Map<String,String> countrylist = new HashMap<String,String>();
        countrylist.put("US", "United States");
        countrylist.put("CH", "China");
        countrylist.put("SG", "Singapore");
        countrylist.put("MY", "Malaysia");
        return countrylist;
    }
}
