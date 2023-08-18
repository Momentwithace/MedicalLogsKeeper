package org.ace.medfilesystem.service.patients;

import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.response.DeletePatient;
import org.ace.medfilesystem.data.dtos.response.RegisterPatientResponse;
import org.ace.medfilesystem.data.dtos.response.UpdatePatientDetailsResponse;
import org.ace.medfilesystem.data.dtos.response.ViewPatientDetailsRespond;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.data.repository.PatientRepository;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public RegisterPatientResponse registerPatient(RegisterPatientRequest request) {
        Patient patient = new Patient();
        patient.setEmail(request.getEmail());
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setPassword(request.getPassword());

        patientRepository.save(patient);
        return new RegisterPatientResponse("patient registered successfully", patient.getId());
    }

    @Override
    public Patient findPatientByID(Long patientId) throws PatientNotFoundException {
        return patientRepository.findById(patientId).orElseThrow(
                () -> new PatientNotFoundException("patient with id "+patientId+" not found")
        );
    }

    @Override
    public UpdatePatientDetailsResponse updatePatientDetails(Long patientId) {
        return null;
    }

    @Override
    public ViewPatientDetailsRespond viewPatientDetails(Long patientId) {
        return null;
    }

    @Override
    public DeletePatient deletePatient(Long patienceId) {
        return null;
    }
}
