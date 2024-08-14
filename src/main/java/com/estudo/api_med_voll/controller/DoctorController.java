package com.estudo.api_med_voll.controller;

import com.estudo.api_med_voll.model.Doctor;
import com.estudo.api_med_voll.record.DoctorDto;
import com.estudo.api_med_voll.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gerenciar Médicos", description = "Operações relacionadas a médicos")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @Operation(summary = "Criar um novo médico", description = "Enviando um DoctorDto, um novo médico será criado")
    @PostMapping("/createDoctor")
    @Transactional
    public void createDoctor(@RequestBody @Valid DoctorDto doctorDto) {
        service.saveDoctor(new Doctor(doctorDto));
    }

    @Operation(summary = "Listar todos os médicos", description = "Listar todos os médicos cadastrados")
    @GetMapping
    public ResponseEntity<List<Doctor>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Buscar médico por ID", description = "Buscar médico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
}
