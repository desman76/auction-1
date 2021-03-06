package com.landing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @RequestMapping()
    public String getHelloPage(Model model){
        model.addAttribute("name", "some guest");
        return "hello";
    }
}
