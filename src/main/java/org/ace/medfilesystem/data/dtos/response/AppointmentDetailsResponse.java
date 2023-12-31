package org.ace.medfilesystem.data.dtos.response;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.medfilesystem.data.models.Patient;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDetailsResponse {
    private String id;
    private String date;
    private Patient patient;
    private LocalDateTime dateCreated;
}
