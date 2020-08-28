package com.motors.motorsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleStatusController {
    @GetMapping("/vehicleStatus")
    public String getEmployees(){
        return "vehicleStatus";
    }
}