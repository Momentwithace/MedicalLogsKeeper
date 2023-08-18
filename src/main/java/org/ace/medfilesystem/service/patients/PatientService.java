package org.ace.medfilesystem.service.patients;

import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.request.UpdatePatientRequest;
import org.ace.medfilesystem.data.dtos.response.DeletePatientResponse;
import org.ace.medfilesystem.data.dtos.response.RegisterPatientResponse;
import org.ace.medfilesystem.data.dtos.response.UpdatePatientDetailsResponse;
import org.ace.medfilesystem.data.dtos.response.ViewPatientDetailsRespond;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;

public interface PatientService {
    RegisterPatientResponse registerPatient(RegisterPatientRequest request);
    Patient findPatientByID(String patientId) throws PatientNotFoundException;
    Patient findByEmail(String email) throws PatientNotFoundException;
    UpdatePatientDetailsResponse updatePatientDetails(UpdatePatientRequest updatePatientRequest,  String patientId) throws PatientNotFoundException;
    ViewPatientDetailsRespond viewPatientDetails(String patientId) throws PatientNotFoundException;
    DeletePatientResponse deletePatient(String patienceId) throws PatientNotFoundException;
}
