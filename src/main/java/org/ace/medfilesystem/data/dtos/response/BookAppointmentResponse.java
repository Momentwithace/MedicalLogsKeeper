package org.ace.medfilesystem.data.dtos.response;

import com.med.healthrecords.data.models.Appointment;

import java.util.List;

public class BookAppointmentResponse {
    private String message;
  private  List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getMessage() {
        return message;
    }

    public BookAppointmentResponse(String message, List<Appointment> appointments) {
        this.message = message;
        this.appointments = appointments;
    }
}
