package com.site.controller;

import com.site.Repository.UserRepository;
import com.site.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //用户登录界面
    @GetMapping("login")
    public String login(){
        return "login/index";
    }
//post 用户登录表单信息
    @PostMapping("login")
    public String login(@ModelAttribute User user, RedirectAttributesModelMap redirectAttributesModelMap, ModelMap modelMap, HttpServletRequest request){
        if(userRepository.existsByuserNameAndPassword(user.getUserName(),user.getPassword()))
        {
            HttpSession session = request.getSession();
            User one = userRepository.findByuserNameAndPassword(user.getUserName(),user.getPassword());
            session.setAttribute("user",one);
            session.setMaxInactiveInterval(3600);
            redirectAttributesModelMap.addFlashAttribute("user",one);
            return "redirect:/files";
        }else {
            redirectAttributesModelMap.addFlashAttribute("message","用户不存在,请联系管理员,暂不开放注册!!");
            return "redirect:/user/login";
        }
    }
}
