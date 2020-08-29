package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.VehicleMake;
import com.motors.motorsapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMake")
    public String getStates(Model model){

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakeList);
        return "vehicleMake";
    }

    @PostMapping("/vehicleMake/addNew")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @RequestMapping("/vehicleMake/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "/vehiclemake/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(VehicleMake vehicleMake){

        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";

    }

    @RequestMapping(value = "/vehicleMake/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        vehicleMakeService.delete(id);
        return  "redirect:/vehicleMake";
    }
}
