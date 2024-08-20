package com.estudo.api_med_voll.controller;

import com.estudo.api_med_voll.domain.patient.Patient;
import com.estudo.api_med_voll.record.ListDataPatient;
import com.estudo.api_med_voll.record.PatientData;
import com.estudo.api_med_voll.record.PatientDataDetails;
import com.estudo.api_med_voll.record.PatientUpdateData;
import com.estudo.api_med_voll.service.PatientService;
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

@Tag(name = "Gerenciar Pacientes", description = "Operações relacionadas a pacientes")
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @Operation(summary = "Criar um novo paciente", description = "Enviando um PatientDataDetails, um novo médico será criado")
    @PostMapping("/createPatient")
    @Transactional
    public ResponseEntity<PatientDataDetails> createPatient(@RequestBody @Valid PatientData patientData, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(patientData);
        service.savePatient(patient);
        var uri = uriBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDataDetails(patient));
    }

    @Operation(summary = "Listar todos os pacientes", description = "Listar todos os pacientes cadastrados")
    @GetMapping
    public ResponseEntity<Page<ListDataPatient>> getAll(@PageableDefault(size = 10, sort = {"id"}) Pageable page) {
        return ResponseEntity.ok(service.getAll(page));
    }

    @Operation(summary = "Buscar paciente por ID", description = "Buscar paciente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PatientDataDetails> getById(@PathVariable Long id) {
        var patient = service.getById(id);
        return ResponseEntity.ok((new PatientDataDetails(patient)));
    }

    @Operation(summary = "Atualizar paciente", description = "Atualizar paciente")
    @PutMapping("/updatePatient")
    @Transactional
    public ResponseEntity<PatientDataDetails> updatePatientr(@RequestBody @Valid PatientUpdateData patientUpdateData) {
        var patient = service.getById(patientUpdateData.id());
        patient.updatePatient(patientUpdateData);
        return ResponseEntity.ok(new PatientDataDetails(patient));
    }

    @Operation(summary = "Apagar paciente", description = "Apagar paciente")
    @DeleteMapping("/deletePatiente/{id}")
    @Transactional
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        var patient = service.getById(id);
        service.deletePatient(patient);
        return ResponseEntity.noContent().build();
    }
}
