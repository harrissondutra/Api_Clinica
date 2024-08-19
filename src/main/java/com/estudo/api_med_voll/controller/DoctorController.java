package com.estudo.api_med_voll.controller;

import com.estudo.api_med_voll.model.Doctor;
import com.estudo.api_med_voll.record.DoctorData;
import com.estudo.api_med_voll.record.DoctorUpdateData;
import com.estudo.api_med_voll.record.ListDataDoctor;
import com.estudo.api_med_voll.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public void createDoctor(@RequestBody @Valid DoctorData doctorData) {
        service.saveDoctor(new Doctor(doctorData));
    }

    @Operation(summary = "Listar todos os médicos", description = "Listar todos os médicos cadastrados")
    @GetMapping
    public ResponseEntity<Page<ListDataDoctor>> getAll(@PageableDefault(size = 10, sort = {"id"}) Pageable page) {
        return ResponseEntity.ok(service.getAll(page));
    }

    @Operation(summary = "Buscar médico por ID", description = "Buscar médico por ID")
    @GetMapping("/getById")
    public ResponseEntity<Doctor> getById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Atualizar médico", description = "Atualizar médico")
    @PutMapping("/updateDoctor")
    @Transactional
    public void updateDoctor(@RequestBody @Valid DoctorUpdateData doctorData) {
        var doctor = service.getById(doctorData.id());
        doctor.updateDoctor(doctorData);
    }

    @Operation(summary = "Deletar médico", description = "Deletar médico")
    @DeleteMapping("/deleteDoctor/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        var doctor = service.getById(id);
        service.deleteDoctor(doctor);
    }
}
