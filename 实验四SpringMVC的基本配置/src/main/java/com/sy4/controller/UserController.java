package com.sy4.controller;

import com.sy4.Dao.EquipmentDao;
import com.sy4.Dao.UserDao;
import com.sy4.entity.Equipment;
import com.sy4.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(){
        return "login";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request,ModelMap modelMap){
        request.getSession().invalidate();
        modelMap.addAttribute("message","退出成功");
        return "login";
    }

    @PostMapping("/userlogin")
    public ModelAndView a(@ModelAttribute User user, HttpServletRequest request){
        User one = UserDao.findUser(user.getLoginName(),user.getPassword(),1);
        ModelAndView modelAndView1 = new ModelAndView("login");
        ModelAndView modelAndView2 = new ModelAndView("userview");
        if(one.getId() == null)
        {
            modelAndView1.addObject("message","账户名或密码错误!");
            return modelAndView1;
        }
        UserDao.updatelogintime(one.getId());
        List<Equipment> ListEquipment = EquipmentDao.listEquipmentByid(one.getId());

        HttpSession session = request.getSession();
        session.setAttribute("user",one);
        modelAndView2.addObject("equipments",ListEquipment);
        return modelAndView2;
    }


    @PostMapping("/adminlogin")
    public ModelAndView b(@ModelAttribute User user, HttpServletRequest request){
        User one  = UserDao.findUser(user.getLoginName(),user.getPassword(),0);
        ModelAndView modelAndView1 = new ModelAndView("login");
        ModelAndView modelAndView2 = new ModelAndView("adminview");
        if(one.getId() == null)
        {
            modelAndView1.addObject("message","账户名或密码错误!");
            return modelAndView1;
        }
        UserDao.updatelogintime(one.getId());
        Map<Equipment,String> map=EquipmentDao.listAllequipment();
        HttpSession session = request.getSession();
        session.setAttribute("admin",one);
        modelAndView2.addObject("equipments",map);
        session.setAttribute("list",UserDao.getuserlist());

        return modelAndView2;
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register/equipment")
    public String registerEquipmentPage(@ModelAttribute Equipment equipment,ModelMap modelMap,HttpServletRequest request){
        if(request.getSession().getAttribute("admin")==null){
            modelMap.addAttribute("message","重新请登录!!");
            return "/login";
        }

        boolean notok = EquipmentDao.addequipment(equipment.getName(),equipment.getDescription(),equipment.getCode(),
                equipment.getPrice(),equipment.getPlace(),equipment.getUserId());
        Map<Equipment,String> map=EquipmentDao.listAllequipment();
        if(notok){
            modelMap.addAttribute("message","添加失败");
        }else{
            modelMap.addAttribute("message","添加成功");
        }
        modelMap.addAttribute("equipments",map);
        HttpSession session = request.getSession();
        session.setAttribute("list",UserDao.getuserlist());
        return "adminview";
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute User user,HttpServletRequest request){
        boolean notok = UserDao.createUser(user.getLoginName(),user.getRealName(),user.getPassword(),user.getTel(),user.getEmail());
        ModelAndView modelAndView1 = new ModelAndView("register");
        ModelAndView modelAndView2 = new ModelAndView("userview");
        if(notok){
            modelAndView1.addObject("message","注册失败,用户名重复!!");
            return modelAndView1;
        }else{
            User one = UserDao.findUser(user.getLoginName(),user.getPassword(),1);
            List<Equipment> ListEquipment = EquipmentDao.listEquipmentByid(one.getId());
            HttpSession session = request.getSession();
            session.setAttribute("user",one);
            modelAndView2.addObject("equipments",ListEquipment);
            return modelAndView2;
        }
    }
}
