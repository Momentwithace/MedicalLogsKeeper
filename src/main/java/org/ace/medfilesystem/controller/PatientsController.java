package org.ace.medfilesystem.controller;


import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.response.BaseResponse;
import org.ace.medfilesystem.data.dtos.response.DeletePatientResponse;
import org.ace.medfilesystem.data.dtos.response.RegisterPatientResponse;
import org.ace.medfilesystem.data.dtos.response.ViewPatientDetailsRespond;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.message.success.SuccessMessage;
import org.ace.medfilesystem.service.patients.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/patients")
@AllArgsConstructor
public class PatientsController {
    private final PatientService patientService;

    @PostMapping
    public BaseResponse<RegisterPatientResponse> registerPatient(@RequestBody RegisterPatientRequest request) throws MedicalFileSystemException {
        RegisterPatientResponse response = patientService.registerPatient(request);
        return BaseResponse.<RegisterPatientResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @GetMapping("view/{patientId}")
    public BaseResponse<ViewPatientDetailsRespond> viewPatient(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        ViewPatientDetailsRespond response = patientService.viewPatientDetails(patientId);
        return BaseResponse.<ViewPatientDetailsRespond>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @DeleteMapping("delete/{patientId}")
    public BaseResponse<DeletePatientResponse> deletePatient(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        DeletePatientResponse response = patientService.deletePatient(patientId);
        return BaseResponse.<DeletePatientResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }
}
