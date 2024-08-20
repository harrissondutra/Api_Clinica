package com.estudo.api_med_voll.record;

import com.estudo.api_med_voll.domain.address.Address;
import com.estudo.api_med_voll.domain.doctor.Doctor;
import com.estudo.api_med_voll.enumerated.Specialty;

public record DoctorDataDetails(
        Long id,
        String name,
        String email,
        String crm,
        String phone,
        Specialty specialty,
        Address address
) {
    public DoctorDataDetails (Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
