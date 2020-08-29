package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.VehicleModel;
import com.motors.motorsapp.services.LocationService;
import com.motors.motorsapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehiclemodel")
    public String getStates(Model model){

        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModelList);
        return "vehiclemodel";
    }

    @PostMapping("/vehiclemodel/addNew")
    public String addNew(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehiclemodel";
    }

    @RequestMapping("/vehiclemodel/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(int id){
        return vehicleModelService.findById(id);
    }

    @RequestMapping(value = "/vehiclemodel/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(VehicleModel vehicleModel){

        vehicleModelService.save(vehicleModel);
        return "redirect:/vehiclemodel";

    }

    @RequestMapping(value = "/vehiclemodel/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        vehicleModelService.delete(id);
        return  "redirect:/vehiclemodel";
    }
}
