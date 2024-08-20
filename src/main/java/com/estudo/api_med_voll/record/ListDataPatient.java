package com.estudo.api_med_voll.record;

import com.estudo.api_med_voll.domain.doctor.Doctor;
import com.estudo.api_med_voll.domain.patient.Patient;
import com.estudo.api_med_voll.enumerated.Specialty;

public record ListDataPatient(
        Long id,
        String nome,
        String email,
        String cpf,
        Boolean active
) {

    public ListDataPatient(Patient patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getCpf(),
                patient.getActive());
    }
}
