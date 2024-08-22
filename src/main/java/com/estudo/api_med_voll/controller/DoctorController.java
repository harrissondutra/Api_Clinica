package com.estudo.api_med_voll.controller;

import com.estudo.api_med_voll.domain.doctor.Doctor;
import com.estudo.api_med_voll.record.*;
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
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Gerenciar Médicos", description = "Operações relacionadas a médicos")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @Operation(summary = "Criar um novo médico", description = "Enviando um DoctorDataDetails, um novo médico será criado")
    @PostMapping("/createDoctor")
    @Transactional
    public ResponseEntity<DoctorDataDetails> createDoctor(@RequestBody @Valid DoctorData doctorData, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(doctorData);
        service.saveDoctor(doctor);
        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDataDetails(doctor));
    }

    @Operation(summary = "Listar todos os médicos", description = "Listar todos os médicos cadastrados")
    @GetMapping
    public ResponseEntity<Page<ListDataDoctor>> getAll(@PageableDefault(size = 10, sort = {"id"}) Pageable page) {
        return ResponseEntity.ok(service.getAll(page));
    }

    @Operation(summary = "Buscar médico por ID", description = "Buscar médico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDataDetails> getById(@PathVariable Long id) {
        var doctor = service.getById(id);
        return ResponseEntity.ok((new DoctorDataDetails(doctor)));
    }

    @Operation(summary = "Atualizar médico", description = "Atualizar médico")
    @PutMapping("/updateDoctor")
    @Transactional
    public ResponseEntity<DoctorDataDetails> updateDoctor(@RequestBody @Valid DoctorUpdateData doctorData) {
        var doctor = service.getById(doctorData.id());
        doctor.updateDoctor(doctorData);
        return ResponseEntity.ok(new DoctorDataDetails(doctor));
    }

    @Operation(summary = "Deletar médico", description = "Deletar médico")
    @DeleteMapping("/deleteDoctor/{id}")
    @Transactional
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        var doctor = service.getById(id);
        service.deleteDoctor(doctor);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Ativar/Desativar médico", description = "Ativar/Desativar médico")
    @PutMapping("/setActive/{id}")
    @Transactional
    public ResponseEntity<DoctorDataDetails> setActive(@PathVariable Long id) {
        var doctor = service.getById(id);
        doctor.setActive(!doctor.getActive());
        return ResponseEntity.ok(new DoctorDataDetails(doctor));
    }
}
