package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.models.VehicleModel;
import com.motors.motorsapp.repositories.LocationRepository;
import com.motors.motorsapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    //list of objects
    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }
    //save new

    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }
    //edit //get by id

    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        vehicleModelRepository.deleteById(id);
    }
}
