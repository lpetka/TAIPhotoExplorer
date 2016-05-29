package com.agh.tai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    private final String startingWebsite = "https://api.imgur.com/oauth2/authorize?client_id=6e099b0f1a86a15&response_type=token";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView method()
    {
        return new ModelAndView("redirect:" + startingWebsite);
    }

    @RequestMapping("/index")
    String index(Model model) {
        model.addAttribute("message", "Logged in");
        return "index";
    }
}
