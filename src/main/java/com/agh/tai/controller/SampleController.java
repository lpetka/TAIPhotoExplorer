package com.agh.tai.controller;

import com.agh.tai.model.UserCredentials;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SampleController {

    private final String startingWebsite = "https://api.imgur.com/oauth2/authorize?client_id=6e099b0f1a86a15&response_type=token";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView method()
    {
        return new ModelAndView("redirect:" + startingWebsite);
    }

    @RequestMapping(value = "/user/credentials", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody UserCredentials addUserCredentials(@RequestBody UserCredentials userCredentials, HttpSession session) {
        session.setAttribute("access_token", userCredentials.getAccessToken());
        session.setAttribute("refresh_token", userCredentials.getRefreshToken());
        session.setAttribute("account_username", userCredentials.getAccountUsername());
        return userCredentials;
    }

    @RequestMapping("/index")
    String index(Model model, HttpSession session) {
        model.addAttribute("message", "Logged in as " + session.getAttribute("account_username"));
        return "index";
    }
}
