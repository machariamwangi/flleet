package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Country;
import com.motors.motorsapp.models.State;
import com.motors.motorsapp.services.CountryService;
import com.motors.motorsapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/state")
    public String getStates(Model model){
        List<State> stateList  = stateService.getStates();
        model.addAttribute("states", stateList);
        List<Country> countryList  = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "state";
    }

    @PostMapping("/state/addNew")
    public String addNew(State state){
        stateService.save(state);
        return "redirect:/state";
    }

    @RequestMapping("/state/findById")
    @ResponseBody
    public Optional<State> findById(int id){
        return stateService.findById(id);
    }

    @RequestMapping(value = "/state/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(State state){

        stateService.save(state);
        return "redirect:/state";

    }

    @RequestMapping(value = "/state/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        stateService.delete(id);
        return  "redirect:/state";
    }
}
