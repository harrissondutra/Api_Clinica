package com.estudo.api_med_voll.domain.patient;

import com.estudo.api_med_voll.domain.address.Address;
import com.estudo.api_med_voll.enumerated.Specialty;
import com.estudo.api_med_voll.record.DoctorData;
import com.estudo.api_med_voll.record.DoctorUpdateData;
import com.estudo.api_med_voll.record.PatientData;
import com.estudo.api_med_voll.record.PatientUpdateData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "patient")
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private Boolean active = true;

    @Embedded
    private Address address;

    public Patient(PatientData patientData) {
        this.name = patientData.name();
        this.email = patientData.email();
        this.phone = patientData.phone();
        this.cpf = patientData.cpf();
        this.address = new Address(patientData.address());

    }

    public void updatePatient(@Valid PatientUpdateData patientUpdateData) {
        if(patientUpdateData.name() != null) this.name = patientUpdateData.name();
        if (patientUpdateData.phone() != null) this.phone = patientUpdateData.phone();
        if (patientUpdateData.addressData() != null) this.address.updateAddress(patientUpdateData.addressData());

    }
}
