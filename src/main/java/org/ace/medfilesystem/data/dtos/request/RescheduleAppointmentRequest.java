package org.ace.medfilesystem.data.dtos.request;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.medfilesystem.data.models.Patient;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RescheduleAppointmentRequest {
    private String patientId;
    private String date;
    private Patient patient;
    private LocalDateTime dateCreated;
}
