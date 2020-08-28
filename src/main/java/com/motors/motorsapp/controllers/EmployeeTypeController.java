package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.EmployeeType;
import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.services.EmployeeTypeService;
import com.motors.motorsapp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeType")
    public String getEmployeeType(Model model){

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeType();
        model.addAttribute("employeeTypes", employeeTypeList);
        return "employeeType";
    }

    @PostMapping("/employeeType/addNew")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";
    }

    @RequestMapping("/employeeType/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id){
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employeeType/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(EmployeeType employeeType){

        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";

    }

    @RequestMapping(value = "/employeeType/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        employeeTypeService.delete(id);
        return  "redirect:/employeeType";
    }
}
