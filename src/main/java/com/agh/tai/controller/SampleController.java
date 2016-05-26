package com.agh.tai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("message", "HELLO WORLD");
        return "index";
    }

}
