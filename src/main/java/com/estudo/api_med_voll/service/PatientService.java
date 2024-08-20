package com.estudo.api_med_voll.service;

import com.estudo.api_med_voll.domain.patient.Patient;
import com.estudo.api_med_voll.record.ListDataPatient;
import com.estudo.api_med_voll.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;


    public void savePatient(Patient patient) {
        try {
            repository.save(patient);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar paciente" + e.getCause());
        }
//        repository.save(doctor);
    }

    public Page<ListDataPatient> getAll(Pageable page) {
        return repository.findAllByActiveTrue(page).map(ListDataPatient::new);
    }

    public Patient getById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deletePatient(Patient patient) {
        patient.setActive(false);
    }
}
