package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.social.twitter.api.Twitter;
@Controller
public class HelloController {

    @Autowired
    private Twitter twitter;
    @RequestMapping("/hello")
    public String hello(@RequestParam(defaultValue = "apersonlikesc") String search,Model model)
    {
        SearchResults searchResults = twitter.searchOperations().search(search);
        String text = searchResults.getTweets().get(0).getText();
        model.addAttribute("message",text);
        return "resultPage";
    }

}
