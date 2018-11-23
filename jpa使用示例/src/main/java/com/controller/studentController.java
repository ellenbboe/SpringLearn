package com.controller;

import com.service.service;
import com.studnet.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class studentController {
    @Autowired
    service service;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/add")
    public String addsutdent(StudentEntity studentEntity){
        studentEntity.setSage(13);
        studentEntity.setSid(1009);
        studentEntity.setSname("王");

        service.save(studentEntity);
        return "success";
    }
}
