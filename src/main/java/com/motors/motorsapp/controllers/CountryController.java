package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Country;
import com.motors.motorsapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model){
        List<Country> countryList  = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "country";
    }

    @PostMapping("/countries/addNew")
    public String addNew(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping("/countries/findById")
    @ResponseBody
    public Optional<Country> findById(int id){
       return countryService.findById(id);
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(Country country){

        countryService.save(country);
        return "redirect:/countries";

    }

    @RequestMapping(value = "/countries/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        countryService.delete(id);
        return  "redirect:/countries";
    }
}
