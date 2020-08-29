package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Supplier;
import com.motors.motorsapp.services.CountryService;
import com.motors.motorsapp.services.StateService;
import com.motors.motorsapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired	private StateService stateService;
    @Autowired	private CountryService countryService;

    @GetMapping("/supplier")
    public String getSuppliers(Model model){
        model.addAttribute("suppliers", supplierService.getSuppliers());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());

        return "supplier";
    }

    @PostMapping("/supplier/addNew")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @RequestMapping("/supplier/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id){
        return supplierService.findById(id);
    }

    @RequestMapping(value = "/supplier/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(Supplier supplier){

        supplierService.save(supplier);
        return "redirect:/supplier";

    }

    @RequestMapping(value = "/supplier/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        supplierService.delete(id);
        return  "redirect:/supplier";
    }
}
