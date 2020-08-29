package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Vehicle;
import com.motors.motorsapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController {
//    @GetMapping("/vehicle")
//    public String getEmployees(){
//        return "vehicle";
//    }

    @Autowired
    private VehicleService vehicleService;
    @Autowired	private LocationService locationService;
    @Autowired	private EmployeeService employeeService;
    @Autowired	private VehicleMakeService vehicleMakeService;
    @Autowired	private VehicleStatusService vehicleStatusService;
    @Autowired	private VehicleTypeService vehicleTypeService;
    @Autowired	private VehicleModelService vehicleModelService;

    @GetMapping("/vehicle")
    public String getVehicles(Model model) {

        model.addAttribute("vehicles", vehicleService.getVehicleServices());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatus());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleType());
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
        return "Vehicle";
    }

    @PostMapping("/vehicle/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle";
    }

    @RequestMapping("vehicle/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id) {
        return vehicleService.findById(id);
    }

    @RequestMapping(value="/vehicle/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle";
    }

    @RequestMapping(value="/vehicles/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicle";
    }
}
