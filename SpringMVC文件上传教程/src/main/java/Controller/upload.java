package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class upload {

    @RequestMapping(method = RequestMethod.GET)
    public String go(){
        return "index";
    }
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public void process(@RequestPart("file") MultipartFile file) throws IOException {
        System.out.println(file.getName());
        file.transferTo(new File("/tmp/springmvc/"+file.getOriginalFilename()));
    }

}
