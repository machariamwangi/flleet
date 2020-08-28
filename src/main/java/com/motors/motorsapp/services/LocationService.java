package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    //list of objects
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }
    //save new

    public void save(Location location){
        locationRepository.save(location);
    }
    //edit //get by id

    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        locationRepository.deleteById(id);
    }
}
