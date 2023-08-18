package org.ace.medfilesystem.service.medicalRecords;

import org.ace.medfilesystem.data.dtos.request.AddRecordRequest;
import org.ace.medfilesystem.data.dtos.response.AddRecordResponse;
import org.ace.medfilesystem.data.dtos.response.ArchiveRecordResponse;
import org.ace.medfilesystem.data.dtos.response.DeleteRecordResponse;
import org.ace.medfilesystem.data.dtos.response.UnarchiveRecordResponse;
import org.ace.medfilesystem.data.models.MedicalRecord;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.data.repository.MedicalRecordRepository;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;
import org.ace.medfilesystem.service.patients.PatientService;
import org.springframework.stereotype.Service;
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
    public AddRecordResponse addRecord(AddRecordRequest request) throws PatientNotFoundException {
        MedicalRecord medicalRecord = new MedicalRecord();
        Patient patient = patientService.findPatientByID(request.getPatientId());
        medicalRecord.setRecordHolder(patient);
        medicalRecord.setTemperature(request.getTemperature());
        medicalRecord.setTemperatureUnit(request.getTemperatureUnit());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecordRepository.save(medicalRecord);
        return new AddRecordResponse("record added successfully",  getPatientMedicalRecord(patient.getId()));
    }

    @Override
    public List<MedicalRecord> getPatientMedicalRecord(Long patientID) {
        return medicalRecordRepository.findAll().stream()
                .filter(medicalRecord -> medicalRecord.getRecordHolder().getId().equals(patientID))
                .toList();
    }

    @Override
    public DeleteRecordResponse deleteMedicalRecord(Long id) {
        return null;
    }

    @Override
    public ArchiveRecordResponse archiveRecord(Long id) {
        return null;
    }

    @Override
    public UnarchiveRecordResponse unarchiveRecord(Long id) {
        return null;
    }
}
