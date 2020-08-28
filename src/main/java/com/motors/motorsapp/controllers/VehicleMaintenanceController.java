package com.motors.motorsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {
    @GetMapping("/vehicleMaintenance")
    public String getEmployees(){
        return "vehicleMaintenance";
    }
}
