package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.VehicleStatus;
import com.motors.motorsapp.repositories.LocationRepository;
import com.motors.motorsapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;
    //list of objects
    public List<VehicleStatus> getVehicleStatus(){
        return vehicleStatusRepository.findAll();
    }
    //save new

    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }
    //edit //get by id

    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        vehicleStatusRepository.deleteById(id);
    }
}
