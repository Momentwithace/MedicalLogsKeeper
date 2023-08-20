package org.ace.medfilesystem.service.appointment;


import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.data.dtos.request.RescheduleAppointmentRequest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.data.models.Appointment;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.data.repository.AppointmentRepository;
import org.ace.medfilesystem.data.repository.PatientRepository;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.message.error.ErrorMessage;
import org.ace.medfilesystem.message.success.SuccessMessage;
import org.ace.medfilesystem.service.patients.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final PatientRepository patientRepository;


    @Override
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest request) throws MedicalFileSystemException {
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.PATIENT_NOT_FOUND));
        Appointment appointment = Appointment.builder()
                .id(patient.getId())
                .date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                .dateCreated(LocalDateTime.now())
                .patient(patient)
                .build();
        appointmentRepository.save(appointment);
        return new BookAppointmentResponse(SuccessMessage.APPOINTMENT_SUCCESSFULLY_BOOK, appointment.getId());
    }


    @Override
    public AppointmentDetailsResponse viewAppointmentDetails(String patientId) throws MedicalFileSystemException {
        Appointment appointment = appointmentRepository.findById(patientId).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.APPOINTMENT_NOT_FOUND));
        return AppointmentDetailsResponse.builder()
                .id(appointment.getId())
                .patient(appointment.getPatient())
                .date(appointment.getDate())
                .dateCreated(appointment.getDateCreated())
                .build();
    }

    @Override
    public RemoveAppointmentResponse removeAppointment(String patientId) throws MedicalFileSystemException {
        Appointment appointment = appointmentRepository.findById(patientId).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.APPOINTMENT_NOT_FOUND));
        appointmentRepository.delete(appointment);
        return RemoveAppointmentResponse.builder()
                .id(appointment.getId())
                .message(SuccessMessage.APPOINTMENT_SUCCESSFULLY_REMOVED)
                .build();
    }

    @Override
    public RescheduleAppointResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest) throws MedicalFileSystemException {
    Appointment appointment = appointmentRepository.findById(rescheduleAppointmentRequest.getPatientId()).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.APPOINTMENT_NOT_FOUND));
    appointment.setId(rescheduleAppointmentRequest.getPatientId());
    appointment.setDate(rescheduleAppointmentRequest.getDate());
    appointment.setPatient(rescheduleAppointmentRequest.getPatient());
    appointment.setDateCreated(rescheduleAppointmentRequest.getDateCreated());
        appointmentRepository.save(appointment);
        return RescheduleAppointResponse.builder()
                .message(SuccessMessage.APPOINTMENT_SUCCESSFULLY_RESCHEDULED)
                .patientId(appointment.getId())
                .build();
    }

    @Override
    public CancelAppointmentResponse cancelAppointment(String patientId) throws MedicalFileSystemException {
        Appointment appointment = appointmentRepository.findById(patientId).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.APPOINTMENT_NOT_FOUND));
        appointmentRepository.delete(appointment);
        return CancelAppointmentResponse.builder()
                .id(appointment.getId())
                .message(SuccessMessage.APPOINTMENT_SUCCESSFULLY_CANCELLED)
                .build();
    }

    @Override
    public DeleteAppointmentResponse deleteAppointment(String patientId) throws MedicalFileSystemException {
        Appointment appointment = appointmentRepository.findById(patientId).orElseThrow(() -> new MedicalFileSystemException(ErrorMessage.APPOINTMENT_NOT_FOUND));
        appointmentRepository.delete(appointment);
        return DeleteAppointmentResponse.builder()
                    .id(appointment.getId())
                    .message(SuccessMessage.APPOINTMENT_SUCCESSFULLY_DELETED)
                    .build();
    }
}
