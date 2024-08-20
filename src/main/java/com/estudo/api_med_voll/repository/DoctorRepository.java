package com.estudo.api_med_voll.repository;

import com.estudo.api_med_voll.domain.doctor.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable page);

    Doctor findDoctorById(Long id);

}
