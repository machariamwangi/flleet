package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Country;
import com.motors.motorsapp.models.State;
import com.motors.motorsapp.repositories.CountryRepository;
import com.motors.motorsapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;
    //list of states
    public List<State> getStates(){
        return stateRepository.findAll();
    }
    //save new state

    public void save(State state){
        stateRepository.save(state);
    }
    //edit state //get by id

    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    //delete state
    public void delete(Integer id){
        stateRepository.deleteById(id);
    }
}
