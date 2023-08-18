package org.ace.medfilesystem.service.appointment;


import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.data.dtos.request.RescheduleAppointmentReuest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.data.models.Appointment;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;

import java.util.List;

public interface AppointmentService {
    BookAppointmentResponse bookAppointment(BookAppointmentRequest request) throws PatientNotFoundException;
    List<Appointment> getPatientAppointments(Long patientID);
    AppointmentDetailsResponse viewAppointmentDetails(Long patientId);
    RescheduleAppointResponse rescheduleAppointment(RescheduleAppointmentReuest rescheduleAppointmentReuest);
    CancelAppointementResponse cancelAppointment(Long id);
    DeleteAppointmentResponse deleteAppointment(Long id);
}
