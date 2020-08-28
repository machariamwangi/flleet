package com.motors.motorsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {
    @GetMapping("/vehicleMovement")
    public String getEmployees(){
        return "vehicleMovement";
    }
}
