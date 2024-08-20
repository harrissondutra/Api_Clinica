package com.estudo.api_med_voll.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.estudo.api_med_voll.domain.doctor.Doctor;
import com.estudo.api_med_voll.domain.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    Page<Patient> findAllByActiveTrue(Pageable page);
}
