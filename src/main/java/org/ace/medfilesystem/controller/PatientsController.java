package org.ace.medfilesystem.controller;


import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.service.patients.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientsController {
    private final PatientService patientService;

    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<?> registerPatient(@RequestBody RegisterPatientRequest request) {
        return ResponseEntity.ok(patientService.registerPatient(request));
    }
}
