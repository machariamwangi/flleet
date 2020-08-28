package com.motors.motorsapp.services;

import com.motors.motorsapp.models.JobTitle;
import com.motors.motorsapp.models.Location;
import com.motors.motorsapp.repositories.JobTitleRepository;
import com.motors.motorsapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;
    //list of objects
    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }
    //save new

    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }
    //edit //get by id

    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    //delete
    public void delete(Integer id){
        jobTitleRepository.deleteById(id);
    }
}
