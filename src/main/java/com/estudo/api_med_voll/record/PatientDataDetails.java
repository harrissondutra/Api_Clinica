package com.estudo.api_med_voll.record;

import com.estudo.api_med_voll.domain.address.Address;
import com.estudo.api_med_voll.domain.doctor.Doctor;
import com.estudo.api_med_voll.domain.patient.Patient;
import com.estudo.api_med_voll.enumerated.Specialty;

public record PatientDataDetails(
        Long id,
        String name,
        String email,
        String cpf,
        String phone,
        Address address,
        Boolean active
) {
    public PatientDataDetails(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(), patient.getPhone(), patient.getAddress(), patient.getActive());
    }
}
