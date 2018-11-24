package com.site.controller;

import com.site.Exception.StorageFileNotFoundException;
import com.site.service.StorageService;
import com.site.service.WallPaperStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("wallpaper")
public class wallpaperController {

    private final StorageService storageService;

    @Autowired
    public wallpaperController(@Qualifier("wallPaperStorageService") StorageService storageService) {
        this.storageService = storageService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String listUploadedFiles(@RequestParam(value = "page",defaultValue = "1")Integer pagenum,Model model) throws IOException {
        Integer size = 9;
        Map<String,String> map = storageService.loadAll(pagenum);
        model.addAttribute("wallpapers", map);
        //联系数据库
        Integer sum = storageService.filecount();
        Integer length = sum%size > 0?sum/size+1:sum/size;
        model.addAttribute("length",length);
        model.addAttribute("page",pagenum);
        return "wallpaper/index";
    }


    @GetMapping("download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

////    上传页面
//    @RequestMapping(value = "/upload",method = RequestMethod.GET)
//    public String index(){
//        return "/wallpaper/upfile";
//    }

//    @RequestMapping(value = "/upload",method = RequestMethod.POST)
//    public String a(){
//        return null;
//    }
//处理异常
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
