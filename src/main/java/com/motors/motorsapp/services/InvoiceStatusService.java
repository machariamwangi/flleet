package com.motors.motorsapp.services;

import com.motors.motorsapp.models.InvoiceStatus;
import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.repositories.InvoiceStatusRepository;
import com.motors.motorsapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;
    //list of objects
    public List<InvoiceStatus> getInvoiceStatus(){
        return invoiceStatusRepository.findAll();
    }
    //save new

    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }
    //edit //get by id

    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        invoiceStatusRepository.deleteById(id);
    }
}
