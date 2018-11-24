package com.site.controller;

import com.site.Exception.StorageFileNotFoundException;
import com.site.Repository.FileRepository;
import com.site.Repository.UserRepository;
import com.site.entity.FileEntity;
import com.site.entity.User;
import com.site.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("files")
public class FileUploadController {
    @Autowired
    private UserRepository userRepository;

    private final StorageService storageService;
//服务方法
    @Autowired
    public FileUploadController(@Qualifier("fileSystemStorageService") StorageService storageService) {
        this.storageService = storageService;
    }

    //上传主页面 files/upload
    @RequestMapping(value = "upload",method = RequestMethod.GET)
    public String uploadpage(HttpServletRequest request,ModelMap modelMap){
        if(request.getSession().getAttribute("user") == null){
            return "login/index";
        }
//        HttpSession session = request.getSession();
//        modelMap.addAttribute("user",session.getAttribute("user"));
        return "file/upfile";
    }

    // 文件主页面 user登录后到这里 /file/index
    @RequestMapping(method = RequestMethod.GET)
    public String index(@ModelAttribute("user") User user, ModelMap modelMap, HttpServletRequest request){
        if(request.getSession().getAttribute("user") == null&&user.getUserName() == null&&user.getPassword() == null&&
                !userRepository.existsByuserNameAndPassword(user.getUserName(),user.getPassword())){
            return "login/index";
        }
        User one = (User)request.getSession().getAttribute("user");
        modelMap.addAttribute("user",one);
        //获取上传的文件列表(数据库)
        modelMap.addAttribute("filelist",storageService.loadAllByOwenId(one.getId()));
        return "file/index";
    }
////下载  将文件写到头里面
    @GetMapping("{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    //上传保存文件 转到首页
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributesModelMap redirectAttributesModelMap, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        storageService.store(file,user.getId());
        redirectAttributesModelMap.addFlashAttribute("filelist",storageService.loadAllByOwenId(user.getId()));
        return "redirect:/files";
    }







    //处理异常
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
