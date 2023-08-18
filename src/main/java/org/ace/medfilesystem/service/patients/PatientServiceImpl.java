package org.ace.medfilesystem.service.patients;

import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.response.DeletePatient;
import org.ace.medfilesystem.data.dtos.response.RegisterPatientResponse;
import org.ace.medfilesystem.data.dtos.response.UpdatePatientDetailsResponse;
import org.ace.medfilesystem.data.dtos.response.ViewPatientDetailsRespond;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.data.repository.PatientRepository;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;
import org.ace.medfilesystem.message.error.ErrorMessage;
import org.ace.medfilesystem.message.success.SuccessMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final PasswordEncoder passwordEncoder;


    @Override
    public RegisterPatientResponse registerPatient(RegisterPatientRequest request) {
        if (patientRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException(ErrorMessage.USER_ALREADY_EXIST);
        }

        Patient patient = mapper.map(request, Patient.class);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        patient.setPassword(encodedPassword);

        patientRepository.save(patient);
        return new RegisterPatientResponse(SuccessMessage.REGISTRATION_SUCCESSFULLY, patient.getId());
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
