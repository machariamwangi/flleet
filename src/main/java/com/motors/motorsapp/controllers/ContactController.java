package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Client;
import com.motors.motorsapp.models.Contact;
import com.motors.motorsapp.services.ContactService;
import com.motors.motorsapp.services.CountryService;
import com.motors.motorsapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    @GetMapping("/contact")
    public String getClients(Model model){
        model.addAttribute("contacts", contactService.getContacts());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());

        return "contact";
    }

    @PostMapping("/contact/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/contact/findById")
    @ResponseBody
    public Optional<Contact> findById(int id){
        return contactService.findById(id);
    }

    @RequestMapping(value = "/contact/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(Contact contact){

        contactService.save(contact);
        return "redirect:/contact";

    }

    @RequestMapping(value = "/contact/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        contactService.delete(id);
        return  "redirect:/contact";
    }
}
