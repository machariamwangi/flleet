package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.VehicleMake;
import com.motors.motorsapp.repositories.LocationRepository;
import com.motors.motorsapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;
    //list of objects
    public List<VehicleMake> getVehicleMakes(){
        return vehicleMakeRepository.findAll();
    }
    //save new

    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }
    //edit //get by id

    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        vehicleMakeRepository.deleteById(id);
    }
}
