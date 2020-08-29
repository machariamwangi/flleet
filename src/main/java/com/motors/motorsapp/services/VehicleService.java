package com.motors.motorsapp.services;


import com.motors.motorsapp.models.Vehicle;
import com.motors.motorsapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    //list of states
    public List<Vehicle> getVehicleServices(){
        return vehicleRepository.findAll();
    }
    //save new state

    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
    //edit state //get by id

    public Optional<Vehicle> findById(int id){
        return vehicleRepository.findById(id);
    }

    //delete state
    public void delete(Integer id){
        vehicleRepository.deleteById(id);
    }
}
