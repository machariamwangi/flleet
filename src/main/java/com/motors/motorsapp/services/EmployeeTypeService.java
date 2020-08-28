package com.motors.motorsapp.services;

import com.motors.motorsapp.models.EmployeeType;
import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.repositories.EmployeeTypeRepository;
import com.motors.motorsapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    //list of objects
    public List<EmployeeType> getEmployeeType(){
        return employeeTypeRepository.findAll();
    }
    //save new

    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }
    //edit //get by id

    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        employeeTypeRepository.deleteById(id);
    }
}
