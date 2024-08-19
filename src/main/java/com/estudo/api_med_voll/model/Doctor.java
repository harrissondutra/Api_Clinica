package com.estudo.api_med_voll.model;

import com.estudo.api_med_voll.enumerated.Specialty;
import com.estudo.api_med_voll.record.DoctorData;
import com.estudo.api_med_voll.record.DoctorUpdateData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "doctor")
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String phone;
    private Boolean active = true;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(DoctorData doctorData) {
        this.name = doctorData.name();
        this.email = doctorData.email();
        this.phone = doctorData.phone();
        this.crm = doctorData.crm();
        this.specialty = doctorData.specialty();
        this.address = new Address(doctorData.address());

    }

    public void updateDoctor(@Valid DoctorUpdateData doctorData) {
        if(doctorData.name() != null) this.name = doctorData.name();
        if (doctorData.phone() != null) this.phone = doctorData.phone();
        if (doctorData.addressData() != null) this.address.updateAddress(doctorData.addressData());

    }
}
