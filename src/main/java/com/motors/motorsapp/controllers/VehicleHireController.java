package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.VehicleHire;
import com.motors.motorsapp.services.ClientService;
import com.motors.motorsapp.services.LocationService;
import com.motors.motorsapp.services.VehicleHireService;
import com.motors.motorsapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleHireController {
//    @GetMapping("/vehiclehire")
//    public String getEmployees(){
//
//        return "vehiclehire";
//    }

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired  private VehicleService vehicleService;
    @Autowired  private LocationService locationService;
    @Autowired  private ClientService clientService;


    @GetMapping("/vehiclehire")
    public String getVehicleHires(Model model) {

        model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
        model.addAttribute("vehicles", vehicleService.getVehicleServices());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("clients", clientService.getClients());

        return "vehiclehire";
    }

    @PostMapping("/vehiclehire/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehire";
    }

    @RequestMapping("vehiclehire/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value="/vehiclehire/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehire";
    }

    @RequestMapping(value="/vehiclehire/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehiclehire";
    }
}
