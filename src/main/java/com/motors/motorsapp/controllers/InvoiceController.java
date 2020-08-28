package com.motors.motorsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {
    @GetMapping("/invoice")
    public String getEmployees(){
        return "invoice";
    }
}
