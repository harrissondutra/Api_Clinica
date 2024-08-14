package com.estudo.api_med_voll.repository;

import com.estudo.api_med_voll.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
