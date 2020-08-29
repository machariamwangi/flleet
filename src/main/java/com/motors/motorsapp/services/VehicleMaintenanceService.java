package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Client;
import com.motors.motorsapp.models.VehicleMaintenance;
import com.motors.motorsapp.repositories.ClientRepository;
import com.motors.motorsapp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {
    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;
    //list of states
    public List<VehicleMaintenance> getVehicleMaintainances(){
        return vehicleMaintenanceRepository.findAll();
    }
    //save new state

    public void save(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }
    //edit state //get by id

    public Optional<VehicleMaintenance> findById(int id){
        return vehicleMaintenanceRepository.findById(id);
    }

    //delete state
    public void delete(Integer id){
        vehicleMaintenanceRepository.deleteById(id);
    }
}
