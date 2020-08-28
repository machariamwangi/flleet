package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.EmployeeType;
import com.motors.motorsapp.models.InvoiceStatus;
import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.services.InvoiceStatusService;
import com.motors.motorsapp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatus")
    public String getInvoiceStatus(Model model){

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatuses", invoiceStatusList);
        return "invoiceStatus";
    }

    @PostMapping("/invoiceStatus/addNew")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    @RequestMapping("/invoiceStatus/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "/invoiceStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(InvoiceStatus invoiceStatus){

        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";

    }

    @RequestMapping(value = "/invoiceStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        invoiceStatusService.delete(id);
        return  "redirect:/invoiceStatus";
    }
}
