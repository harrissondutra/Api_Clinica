package com.estudo.api_med_voll.service;

import com.estudo.api_med_voll.domain.doctor.Doctor;
import com.estudo.api_med_voll.record.ListDataDoctor;
import com.estudo.api_med_voll.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<ListDataDoctor> getAll(Pageable page) {
        return repository.findAllByActiveTrue(page).map(ListDataDoctor::new);
    }

    public Doctor getById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteDoctor(Doctor doctor) {
        doctor.setActive(false);
    }
}
