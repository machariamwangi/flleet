package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Invoice;
import com.motors.motorsapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    //list of states
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }
    //save new state

    public void save(Invoice Invoice){
        invoiceRepository.save(Invoice);
    }
    //edit state //get by id

    public Optional<Invoice> findById(int id){
        return invoiceRepository.findById(id);
    }

    //delete state
    public void delete(Integer id){
        invoiceRepository.deleteById(id);
    }
}
