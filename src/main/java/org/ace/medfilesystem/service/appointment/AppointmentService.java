package org.ace.medfilesystem.service.appointment;


import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.data.dtos.request.RescheduleAppointmentRequest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;

public interface AppointmentService {
    BookAppointmentResponse bookAppointment(BookAppointmentRequest request) throws MedicalFileSystemException;
    AppointmentDetailsResponse viewAppointmentDetails(String patientId) throws MedicalFileSystemException;
    RemoveAppointmentResponse removeAppointment(String patientId) throws MedicalFileSystemException;
    RescheduleAppointResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest) throws MedicalFileSystemException;
    CancelAppointmentResponse cancelAppointment(String patientId) throws MedicalFileSystemException;
    DeleteAppointmentResponse deleteAppointment(String patientId) throws MedicalFileSystemException;
}
