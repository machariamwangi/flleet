package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Client;
import com.motors.motorsapp.models.VehicleMaintenance;
import com.motors.motorsapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMaintenanceController {


    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired	private VehicleService vehicleService;
    @Autowired	private SupplierService supplierService;

    @GetMapping("/vehicleMaintenance")
    public String getClients(Model model){
        model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintainances());
        model.addAttribute("vehicles", vehicleService.getVehicleServices());
        model.addAttribute("suppliers", supplierService.getSuppliers());

        return "vehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenance/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping("/vehicleMaintenance/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(int id){
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value = "/vehicleMaintenance/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(VehicleMaintenance vehicleMaintenance){

        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";

    }

    @RequestMapping(value = "/vehicleMaintenance/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        vehicleMaintenanceService.delete(id);
        return  "redirect:/vehicleMaintenance";
    }
}
