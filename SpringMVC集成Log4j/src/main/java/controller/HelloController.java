package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = Logger.getLogger(HelloController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String printhello(ModelMap modelMap)
    {
        logger.info("printhello start!");

        if(logger.isDebugEnabled()){
            logger.debug("inside: printhello");
        }

        logger.error("loggin a sample exception",new Exception("Testing"));

        modelMap.addAttribute("message","hellopage");
        logger.info("printhello end");
        return "hello";
    }

}
