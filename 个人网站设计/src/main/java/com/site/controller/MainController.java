package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    //主页
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

//    @RequestMapping("/movie")
//    public String GetMoviePage(){
//        return "MoviePage";
//    }
//
//
//    @RequestMapping("/game")
//    public String GetGamePage(){
//        return "GamePage";
//    }
//
//    @RequestMapping(value = "/file")
//    public String login(){
//        return "login";
//    }
//
//    @RequestMapping(value = "/file" , method = RequestMethod.POST)
//    public String file(){
//        return "file";
//    }

}
