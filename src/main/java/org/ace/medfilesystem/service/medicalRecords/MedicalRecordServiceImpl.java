package org.ace.medfilesystem.service.medicalRecords;

import org.ace.medfilesystem.data.dtos.request.AddRecordRequest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.data.models.MedicalRecord;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.data.repository.MedicalRecordRepository;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.message.error.ErrorMessage;
import org.ace.medfilesystem.message.success.SuccessMessage;
import org.ace.medfilesystem.service.patients.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientService patientService;

    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository, PatientService patientService) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.patientService = patientService;
    }

    @Override
    public AddRecordResponse addRecord(AddRecordRequest request) throws MedicalFileSystemException {
        Patient patient = patientService.findPatientByID(request.getPatientId());
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setRecordHolder(patient);
        medicalRecord.setTemperature(request.getTemperature());
        medicalRecord.setTemperatureUnit(request.getTemperatureUnit());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecordRepository.save(medicalRecord);
        return new AddRecordResponse(SuccessMessage.RECORD_ADDED_SUCCESSFULLY,  getPatientMedicalRecord(patient.getId()));
    }

    @Override
    public List<MedicalRecord> getPatientMedicalRecord(String patientID) {
        return medicalRecordRepository.findAll().stream()
                .filter(medicalRecord -> medicalRecord.getRecordHolder().getId().equals(patientID))
                .toList();
    }


    @Override
    public RemoveRecordResponse removeRecord(String id) throws MedicalFileSystemException {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.RECORD_NOT_FOUND));
        medicalRecordRepository.delete(medicalRecord);
        return RemoveRecordResponse.builder()
                .message(SuccessMessage.RECORD_REMOVED_SUCCESSFULLY)
                .id(medicalRecord.getId())
                .build();
    }

    @Override
    public DeleteRecordResponse deleteMedicalRecord(String id) throws MedicalFileSystemException {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.RECORD_NOT_FOUND));
        medicalRecordRepository.delete(medicalRecord);
        return DeleteRecordResponse.builder()
                .message(SuccessMessage.DELETED)
                .id(medicalRecord.getId())
                .dateDeleted(LocalDateTime.now())
                .build();
    }

    @Override
    public ArchiveRecordResponse archiveRecord(String id) throws MedicalFileSystemException {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.RECORD_NOT_FOUND));
        if (medicalRecord.getIsArchived()){
            throw new MedicalFileSystemException(ErrorMessage.RECORD_ALREADY_ARCHIVED);
        }
        medicalRecord.setIsArchived(true);
        medicalRecord.setDatedCreated(LocalDateTime.now());
        medicalRecord.setDateUpdated(LocalDateTime.now());
        medicalRecordRepository.save(medicalRecord);
        return ArchiveRecordResponse.builder()
                .message(SuccessMessage.ARCHIVED_SUCCESSFULLY)
                .id(medicalRecord.getId())
                .build();

    }

    @Override
    public UnarchiveRecordResponse unarchiveRecord(String id) throws MedicalFileSystemException {
    MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.RECORD_NOT_FOUND));
    if (!medicalRecord.getIsArchived()){
        throw new MedicalFileSystemException(ErrorMessage.RECORD_ALREADY_UNARCHIVED);
    }
    medicalRecord.setIsArchived(false);
    medicalRecord.setDatedCreated(LocalDateTime.now());
    medicalRecord.setDateUpdated(LocalDateTime.now());
    medicalRecordRepository.save(medicalRecord);
    return UnarchiveRecordResponse.builder()
            .id(medicalRecord.getId())
            .message(SuccessMessage.UNARCHIVED_SUCCESSFULLY)
            .build();
    }
}
