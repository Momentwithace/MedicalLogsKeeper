package org.ace.medfilesystem.service.medicalRecords;

import com.med.healthrecords.data.dataTransferObjects.requests.AddRecordRequest;
import com.med.healthrecords.data.dataTransferObjects.responses.AddRecordResponse;
import com.med.healthrecords.data.models.MedicalRecord;
import com.med.healthrecords.data.models.Patient;
import com.med.healthrecords.data.repository.MedicalRecordRepository;
import com.med.healthrecords.exceptions.PatientNotFoundException;
import com.med.healthrecords.services.patients.PatientService;
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
}
