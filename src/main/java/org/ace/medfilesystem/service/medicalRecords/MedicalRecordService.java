package org.ace.medfilesystem.service.medicalRecords;

import org.ace.medfilesystem.data.dtos.request.AddRecordRequest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.data.models.MedicalRecord;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;

import java.util.List;

public interface MedicalRecordService {
    AddRecordResponse addRecord(AddRecordRequest request) throws MedicalFileSystemException;
    List<MedicalRecord> getPatientMedicalRecord(String patientID);
    RemoveRecordResponse removeRecord(String id);
    DeleteRecordResponse deleteMedicalRecord(String id) throws MedicalFileSystemException;
    ArchiveRecordResponse archiveRecord(String id) throws MedicalFileSystemException;
    UnarchiveRecordResponse unarchiveRecord(String id);


}
