package org.ace.medfilesystem.data.dtos.request;

public class BookAppointmentRequest {
    private long patientId;

    public BookAppointmentRequest(long patientId) {
        this.patientId = patientId;
    }
    public BookAppointmentRequest() {
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

}
