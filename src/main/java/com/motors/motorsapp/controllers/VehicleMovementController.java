package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.VehicleMovement;
import com.motors.motorsapp.services.LocationService;
import com.motors.motorsapp.services.VehicleMovementService;
import com.motors.motorsapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMovementController {
//    @GetMapping("/vehicleMovement")
//    public String getEmployees(){
//        return "vehicleMovement";
//    }

    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired	private VehicleService vehicleService;
    @Autowired	private LocationService locationService;


    @GetMapping("/vehicleMovement")
    public String getVehicleMovements(Model model) {
        model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());

        model.addAttribute("vehicles", vehicleService.getVehicleServices());
        model.addAttribute("locations", locationService.getLocations());



        return "vehicleMovement";
    }

    @PostMapping("/vehicleMovement/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @RequestMapping("vehicleMovement/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value="/vehicleMovement/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @RequestMapping(value="/vehicleMovement/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovement";
    }

}
