package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Invoice;
import com.motors.motorsapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoice")
    public String getStates(Model model){
        model.addAttribute("invoices", invoiceService.getInvoices());
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatus());
        return "invoice";
    }

    @PostMapping("/invoice/addNew")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoice";
    }

    @RequestMapping("/invoice/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id){
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/invoice/update", method = {RequestMethod.PUT, RequestMethod.GET})

    public  String update(Invoice invoice){

        invoiceService.save(invoice);
        return "redirect:/invoice";

    }

    @RequestMapping(value = "/invoice/delete", method = {RequestMethod.DELETE, RequestMethod.GET})

    public String delete(Integer id){
        invoiceService.delete(id);
        return  "redirect:/invoice";
    }
}
