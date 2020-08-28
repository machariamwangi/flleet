package com.motors.motorsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMakeController {
    @GetMapping("/vehicleMake")
    public String getEmployees(){
        return "vehicleMake";
    }
}
