package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import server.filemodel;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class fileuploadcontroller {
    @Autowired
    ServletContext context;

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public ModelAndView fileupload(){
        filemodel filemodel = new filemodel();
        ModelAndView modelAndView = new ModelAndView("fileupload","command",filemodel);
        return modelAndView;
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String fileupload(@Validated filemodel file, BindingResult bindingResult, ModelMap modelMap){
        if(bindingResult.hasErrors()){
            return "fileupload";
        }else{
            MultipartFile multipartFile = file.getFile();
            String uploadPath = context.getRealPath("")+ File.separator;
            System.out.println(uploadPath);
            System.out.println(uploadPath+file.getFile().getOriginalFilename());
            try {
                FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileName = multipartFile.getOriginalFilename();
            modelMap.addAttribute("fileName", fileName);
            return "success";
        }
    }

}
