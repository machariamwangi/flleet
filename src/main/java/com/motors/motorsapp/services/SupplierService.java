package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Client;
import com.motors.motorsapp.models.Supplier;
import com.motors.motorsapp.repositories.ClientRepository;
import com.motors.motorsapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    //list of states
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }
    //save new state

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }
    //edit state //get by id

    public Optional<Supplier> findById(int id){
        return supplierRepository.findById(id);
    }

    //delete state
    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }
}
