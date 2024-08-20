package com.estudo.api_med_voll.record;

import com.estudo.api_med_voll.enumerated.Specialty;
import com.estudo.api_med_voll.domain.doctor.Doctor;

public record ListDataDoctor(
        Long id,
        String nome,
        String email,
        String crm,
        Specialty specialty,
        Boolean active
) {

    public ListDataDoctor(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                doctor.getActive());
    }
}
