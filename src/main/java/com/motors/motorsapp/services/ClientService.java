package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Client;
import com.motors.motorsapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    //list of states
    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    //save new state

    public void save(Client client){
        clientRepository.save(client);
    }
    //edit state //get by id

    public Optional<Client> findById(int id){
        return clientRepository.findById(id);
    }

    //delete state
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
