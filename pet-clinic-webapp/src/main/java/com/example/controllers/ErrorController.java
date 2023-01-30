package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping({"/oups", "/oups.html"})
    public String displayError(){
        return "notimpl";
    }
}
