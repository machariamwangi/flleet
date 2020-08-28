package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.VehicleType;
import com.motors.motorsapp.services.LocationService;
import com.motors.motorsapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleType")
    public String getVehicleTypes(Model model){

        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleType();
        model.addAttribute("vehicleTypes", vehicleTypeList);
        return "vehicleType";
    }

    @PostMapping("/vehicleType/addNew")
    public String addNew(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    @RequestMapping("/vehicleType/findById")
    @ResponseBody
    public Optional<VehicleType> findById(int id){
        return vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "/vehicleType/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(VehicleType vehicleType){

        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";

    }

    @RequestMapping(value = "/vehicleType/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        vehicleTypeService.delete(id);
        return  "redirect:/vehicleType";
    }
}
