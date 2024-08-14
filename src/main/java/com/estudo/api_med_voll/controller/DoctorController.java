package com.estudo.api_med_voll.controller;

import com.estudo.api_med_voll.model.Doctor;
import com.estudo.api_med_voll.record.DoctorDto;
import com.estudo.api_med_voll.service.DoctorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/createDoctor")
    @Transactional
    public void createDoctor(@RequestBody @Valid DoctorDto doctorDto) {
        service.saveDoctor(new Doctor(doctorDto));

    }
}
