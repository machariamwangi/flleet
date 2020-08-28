package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Country;
import com.motors.motorsapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    //list of country
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
    //save new country

    public void save(Country country){
        countryRepository.save(country);
    }
    //edit country //get by id

    public Optional<Country> findById(int id){
        return countryRepository.findById(id);
    }

    //delete country
    public void delete(Integer id){
         countryRepository.deleteById(id);
    }

}
