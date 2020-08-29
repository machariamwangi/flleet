package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Client;
import com.motors.motorsapp.services.ClientService;
import com.motors.motorsapp.services.ContactService;
import com.motors.motorsapp.services.CountryService;
import com.motors.motorsapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {

    @Autowired	private ClientService clientService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    @GetMapping("/client")
    public String getClients(Model model){
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());

        return "client";
    }

    @PostMapping("/client/addNew")
    public String addNew(Client client){
        clientService.save(client);
        return "redirect:/client";
    }

    @RequestMapping("/client/findById")
    @ResponseBody
    public Optional<Client> findById(int id){
        return clientService.findById(id);
    }

    @RequestMapping(value = "/client/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(Client client){

        clientService.save(client);
        return "redirect:/client";

    }

    @RequestMapping(value = "/client/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        clientService.delete(id);
        return  "redirect:/client";
    }
}
