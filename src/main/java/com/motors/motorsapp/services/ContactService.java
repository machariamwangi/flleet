package com.motors.motorsapp.services;

import com.motors.motorsapp.models.Client;
import com.motors.motorsapp.models.Contact;
import com.motors.motorsapp.repositories.ClientRepository;
import com.motors.motorsapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    //list of states
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }
    //save new state

    public void save(Contact contact){
        contactRepository.save(contact);
    }
    //edit state //get by id

    public Optional<Contact> findById(int id){
        return contactRepository.findById(id);
    }

    //delete state
    public void delete(Integer id){
        contactRepository.deleteById(id);
    }
}
