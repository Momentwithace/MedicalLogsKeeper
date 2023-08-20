package org.ace.medfilesystem.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.AddRecordRequest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.data.models.MedicalRecord;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.message.success.SuccessMessage;
import org.ace.medfilesystem.service.medicalRecords.MedicalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/records/")
@AllArgsConstructor
public class MedicalRecordController {
     private final MedicalRecordService medicalRecordService;

    @PostMapping
    public BaseResponse<AddRecordResponse> addRecord(@RequestBody @Valid AddRecordRequest addRecordRequest) throws MedicalFileSystemException {
        AddRecordResponse response = medicalRecordService.addRecord(addRecordRequest);
        return BaseResponse.<AddRecordResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @GetMapping("getRecord/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getPatientRecord(@PathVariable("patientId") String patientId){
        return ResponseEntity.ok(medicalRecordService.getPatientMedicalRecord(patientId));
    }

    @DeleteMapping("remove/{patientId}")
    public BaseResponse<RemoveRecordResponse> removeRecord(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        RemoveRecordResponse response = medicalRecordService.removeRecord(patientId);
        return BaseResponse.<RemoveRecordResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }
    @DeleteMapping("delete/{patientId}")
    public BaseResponse<DeleteRecordResponse> deleteRecord(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        DeleteRecordResponse response = medicalRecordService.deleteMedicalRecord(patientId);
        return BaseResponse.<DeleteRecordResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @PatchMapping("archive/{patientId}")
    public BaseResponse<ArchiveRecordResponse> archiveRecord(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        ArchiveRecordResponse response = medicalRecordService.archiveRecord(patientId);
        return BaseResponse.<ArchiveRecordResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @PatchMapping("unarchive/{patientId}")
    public BaseResponse<UnarchiveRecordResponse> unArchiveRecord(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        UnarchiveRecordResponse response = medicalRecordService.unarchiveRecord(patientId);
        return BaseResponse.<UnarchiveRecordResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }
}
