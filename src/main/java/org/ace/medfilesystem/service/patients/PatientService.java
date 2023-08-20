package org.ace.medfilesystem.service.patients;

import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.request.UpdatePatientRequest;
import org.ace.medfilesystem.data.dtos.response.DeletePatientResponse;
import org.ace.medfilesystem.data.dtos.response.RegisterPatientResponse;
import org.ace.medfilesystem.data.dtos.response.UpdatePatientDetailsResponse;
import org.ace.medfilesystem.data.dtos.response.ViewPatientDetailsRespond;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;

public interface PatientService {
    RegisterPatientResponse registerPatient(RegisterPatientRequest request) throws MedicalFileSystemException;
    UpdatePatientDetailsResponse updatePatientDetails(UpdatePatientRequest updatePatientRequest,  String patientId) throws MedicalFileSystemException;
    ViewPatientDetailsRespond viewPatientDetails(String patientId) throws MedicalFileSystemException;
    DeletePatientResponse deletePatient(String patienceId) throws MedicalFileSystemException;
}
