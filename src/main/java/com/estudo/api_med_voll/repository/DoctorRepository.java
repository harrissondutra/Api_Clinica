package com.estudo.api_med_voll.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.estudo.api_med_voll.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable page);

}
