package org.ace.medfilesystem.service.medicalRecords;

import com.med.healthrecords.data.dataTransferObjects.requests.AddRecordRequest;
import com.med.healthrecords.data.dataTransferObjects.responses.AddRecordResponse;
import com.med.healthrecords.data.models.MedicalRecord;
import com.med.healthrecords.exceptions.PatientNotFoundException;

import java.util.List;

public interface MedicalRecordService {
    AddRecordResponse addRecord(AddRecordRequest request) throws PatientNotFoundException;
    List<MedicalRecord> getPatientMedicalRecord(Long patientID);
    DeleteRecordResponse deleteMedicalRecord(Long id);
    ArchiveRecordResponse archiveRecord(Long id);
    UnarchiveRecordResponse unarchiveRecord(Long id);


}
