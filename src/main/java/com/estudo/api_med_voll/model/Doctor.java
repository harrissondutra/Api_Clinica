package com.estudo.api_med_voll.model;

import com.estudo.api_med_voll.enumerated.Specialty;
import com.estudo.api_med_voll.record.DoctorDto;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(DoctorDto doctorDto) {
        this.name = doctorDto.name();
        this.email = doctorDto.email();
        this.phone = doctorDto.phone();
        this.crm = doctorDto.crm();
        this.specialty = doctorDto.specialty();
        this.address = new Address(doctorDto.address());

    }
}
