package com.motors.motorsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobTitleController {
    @GetMapping("/jobTitle")
    public String getEmployees(){
        return "jobTitle";
    }
}
