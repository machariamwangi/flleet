package com.motors.motorsapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
