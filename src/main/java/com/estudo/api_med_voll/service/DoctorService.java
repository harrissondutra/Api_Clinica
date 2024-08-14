package com.estudo.api_med_voll.service;

import com.estudo.api_med_voll.model.Doctor;
import com.estudo.api_med_voll.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;


    public void saveDoctor(Doctor doctor) {
        repository.save(doctor);
    }
}
