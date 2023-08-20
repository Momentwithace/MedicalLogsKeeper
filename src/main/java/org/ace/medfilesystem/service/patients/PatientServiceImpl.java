package org.ace.medfilesystem.service.patients;

import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.request.UpdatePatientRequest;
import org.ace.medfilesystem.data.dtos.response.DeletePatientResponse;
import org.ace.medfilesystem.data.dtos.response.RegisterPatientResponse;
import org.ace.medfilesystem.data.dtos.response.UpdatePatientDetailsResponse;
import org.ace.medfilesystem.data.dtos.response.ViewPatientDetailsRespond;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.data.repository.PatientRepository;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.message.error.ErrorMessage;
import org.ace.medfilesystem.message.success.SuccessMessage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;
    private final ModelMapper mapper = new ModelMapper();


    @Override
    public RegisterPatientResponse registerPatient(RegisterPatientRequest request) {
        if (patientRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException(ErrorMessage.USER_ALREADY_EXIST);
        }

        Patient patient = mapper.map(request, Patient.class);
        patient.setDateCreated(LocalDateTime.now());
        patientRepository.save(patient);

        return new RegisterPatientResponse(SuccessMessage.REGISTRATION_SUCCESSFULLY, patient.getId());
    }

    @Override
    public Patient findPatientByID(String patientId) throws MedicalFileSystemException {
        return patientRepository.findById(patientId).orElseThrow(
            () -> new MedicalFileSystemException(ErrorMessage.USER_WITH_ID_NOT_FOUND)
        );
    }

    @Override
    public Patient findByEmail(String email) throws MedicalFileSystemException {
        if (!patientRepository.existsByEmail(email)){
            throw new MedicalFileSystemException(ErrorMessage.USER_WITH_EMAIL_NOT_FOUND);
        }
        return patientRepository.findByEmail(email);
    }

    @Override
    public UpdatePatientDetailsResponse updatePatientDetails(UpdatePatientRequest updatePatientRequest, String patientId) throws MedicalFileSystemException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()
                -> new MedicalFileSystemException(ErrorMessage.USER_WITH_ID_NOT_FOUND));
        mapper.map(updatePatientRequest, patient);
        patient.setDateUpdated(LocalDateTime.now());
        Patient patient1 = patientRepository.save(patient);
        UpdatePatientDetailsResponse updatePatientDetailsResponse = new UpdatePatientDetailsResponse();
        updatePatientDetailsResponse.setPatientId(patient1.getId());
        updatePatientDetailsResponse.setMessage(SuccessMessage.UPDATED_MADE_SUCCESSFULLY);
        return updatePatientDetailsResponse;
    }

    @Override
    public ViewPatientDetailsRespond viewPatientDetails(String patientId) throws MedicalFileSystemException {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new MedicalFileSystemException(ErrorMessage.USER_WITH_ID_NOT_FOUND));
        return mapper.map(patient, ViewPatientDetailsRespond.class);
    }

    @Override
    public DeletePatientResponse deletePatient(String patienceId) throws MedicalFileSystemException {
        Patient patient = patientRepository.findById(patienceId).orElseThrow(
                () -> new MedicalFileSystemException(ErrorMessage.USER_WITH_ID_NOT_FOUND)
        );
        patientRepository.delete(patient);
        DeletePatientResponse deletePatientResponse = new DeletePatientResponse();
        deletePatientResponse.setMessage(SuccessMessage.DELETED);
        deletePatientResponse.setDateDelete(LocalDateTime.now());
        deletePatientResponse.setCourseId(patient.getId());
        return deletePatientResponse;
    }
}
