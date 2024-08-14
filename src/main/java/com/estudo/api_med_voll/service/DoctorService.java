package com.estudo.api_med_voll.service;

import com.estudo.api_med_voll.model.Doctor;
import com.estudo.api_med_voll.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;


    public void saveDoctor(Doctor doctor) {
        try {
            repository.save(doctor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar médico" + e.getCause());
        }
//        repository.save(doctor);
    }

    public List<Doctor> getAll() {
        return repository.findAll();
    }

    public Doctor getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }
}
