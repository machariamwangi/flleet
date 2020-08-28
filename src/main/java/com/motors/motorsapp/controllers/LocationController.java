package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Country;
import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.State;
import com.motors.motorsapp.services.CountryService;
import com.motors.motorsapp.services.LocationService;
import com.motors.motorsapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/location")
    public String getStates(Model model){
        List<State> stateList  = stateService.getStates();
        model.addAttribute("states", stateList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Country> countryList  = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "location";
    }

    @PostMapping("/location/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/location";
    }

    @RequestMapping("/location/findById")
    @ResponseBody
    public Optional<Location> findById(int id){
        return locationService.findById(id);
    }

    @RequestMapping(value = "/location/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(Location location){

        locationService.save(location);
        return "redirect:/location";

    }

    @RequestMapping(value = "/location/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        locationService.delete(id);
        return  "redirect:/location";
    }
}
