package org.ace.medfilesystem.service.patients;

import com.med.healthrecords.data.dataTransferObjects.requests.RegisterPatientRequest;
import com.med.healthrecords.data.dataTransferObjects.responses.RegisterPatientResponse;
import com.med.healthrecords.data.models.Patient;
import com.med.healthrecords.exceptions.PatientNotFoundException;

public interface PatientService {
    RegisterPatientResponse registerPatient(RegisterPatientRequest request);
    Patient findPatientByID(Long patientId) throws PatientNotFoundException;
    UpdatePatientDetailsResponse updatePatientDetails(Long patientId);
    ViewPatientDetailsRespond viewPatientDetails(Long patientId);
    DeletePatient deletePatient(Long patienceId);
}
