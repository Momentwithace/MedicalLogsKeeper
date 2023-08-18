package org.ace.medfilesystem.service.appointment;


import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.data.dtos.request.RescheduleAppointmentReuest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.data.models.Appointment;
import org.ace.medfilesystem.data.models.Patient;
import org.ace.medfilesystem.data.repository.AppointmentRepository;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;
import org.ace.medfilesystem.service.patients.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;


    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
    }

    @Override
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest request) throws PatientNotFoundException {
        Appointment appointment = new Appointment();
        Patient patient = patientService.findPatientByID(request.getPatientId());
        appointment.setPatient(patient);
        appointment.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        appointmentRepository.save(appointment);
        return new BookAppointmentResponse("Appointment booked successfully", getPatientAppointments(patient.getId()));
    }


    @Override
    public List<Appointment> getPatientAppointments(Long patientID) {
        return appointmentRepository.findAll().stream()
                .filter(appointment -> appointment.getPatient().getId().equals(patientID))
                .toList();
    }

    @Override
    public AppointmentDetailsResponse viewAppointmentDetails(Long patientId) {
        return null;
    }

    @Override
    public RescheduleAppointResponse rescheduleAppointment(RescheduleAppointmentReuest rescheduleAppointmentReuest) {
        return null;
    }

    @Override
    public CancelAppointementResponse cancelAppointment(Long id) {
        return null;
    }

    @Override
    public DeleteAppointmentResponse deleteAppointment(Long id) {
        return null;
    }
}
