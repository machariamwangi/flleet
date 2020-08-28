package com.motors.motorsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
    @GetMapping("/supplier")
    public String getEmployees(){
        return "supplier";
    }
}
