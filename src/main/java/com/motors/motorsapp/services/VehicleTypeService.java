package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.VehicleType;
import com.motors.motorsapp.repositories.LocationRepository;
import com.motors.motorsapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    //list of objects
    public List<VehicleType> getVehicleType(){
        return vehicleTypeRepository.findAll();
    }
    //save new

    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }
    //edit //get by id

    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        vehicleTypeRepository.deleteById(id);
    }
}
