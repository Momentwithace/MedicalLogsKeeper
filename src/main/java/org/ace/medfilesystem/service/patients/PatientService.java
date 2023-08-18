package org.ace.medfilesystem.service.patients;

import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.response.DeletePatient;
import org.ace.medfilesystem.data.dtos.response.RegisterPatientResponse;
import org.ace.medfilesystem.data.dtos.response.UpdatePatientDetailsResponse;
import org.ace.medfilesystem.data.dtos.response.ViewPatientDetailsRespond;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;

public interface PatientService {
    RegisterPatientResponse registerPatient(RegisterPatientRequest request);
    Patient findPatientByID(Long patientId) throws PatientNotFoundException;
    UpdatePatientDetailsResponse updatePatientDetails(Long patientId);
    ViewPatientDetailsRespond viewPatientDetails(Long patientId);
    DeletePatient deletePatient(Long patienceId);
}
