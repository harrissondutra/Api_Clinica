package com.estudo.api_med_voll.controller;

import com.estudo.api_med_voll.model.Doctor;
import com.estudo.api_med_voll.record.DoctorDto;
import com.estudo.api_med_voll.service.DoctorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
