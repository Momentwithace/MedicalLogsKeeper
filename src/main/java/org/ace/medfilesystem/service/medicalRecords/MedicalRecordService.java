package org.ace.medfilesystem.service.medicalRecords;

import org.ace.medfilesystem.data.dtos.request.AddRecordRequest;
import org.ace.medfilesystem.data.dtos.response.AddRecordResponse;
import org.ace.medfilesystem.data.dtos.response.ArchiveRecordResponse;
import org.ace.medfilesystem.data.dtos.response.DeleteRecordResponse;
import org.ace.medfilesystem.data.dtos.response.UnarchiveRecordResponse;
import org.ace.medfilesystem.data.models.MedicalRecord;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;

import java.util.List;

public interface MedicalRecordService {
    AddRecordResponse addRecord(AddRecordRequest request) throws PatientNotFoundException;
    List<MedicalRecord> getPatientMedicalRecord(Long patientID);
    DeleteRecordResponse deleteMedicalRecord(Long id);
    ArchiveRecordResponse archiveRecord(Long id);
    UnarchiveRecordResponse unarchiveRecord(Long id);


}
