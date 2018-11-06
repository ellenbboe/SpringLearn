package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends MultiActionController {

    public ModelAndView home(HttpServletRequest request, HttpServletResponse response)throws Exception {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("message","home");
        return modelAndView;
    }
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response)throws Exception {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("message","add方法");
        return modelAndView;
    }
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response)throws Exception {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("message","remove方法");
        return modelAndView;
    }
}
