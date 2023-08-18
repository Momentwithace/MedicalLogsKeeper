package org.ace.medfilesystem.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookAppointmentRequest {
    private long patientId;

//    public BookAppointmentRequest(long patientId) {
//        this.patientId = patientId;
//    }
//    public BookAppointmentRequest() {
//    }
//
//    public void setPatientId(long patientId) {
//        this.patientId = patientId;
//    }
//
//    public Long getPatientId() {
//        return patientId;
//    }

}
