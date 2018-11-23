package controller;

import domain.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player)
    {
        Message messag = new Message(player,"Hello,"+player);
        return messag;
    }
}
