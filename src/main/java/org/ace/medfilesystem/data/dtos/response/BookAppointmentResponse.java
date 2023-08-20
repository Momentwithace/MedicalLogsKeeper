package org.ace.medfilesystem.data.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.medfilesystem.data.models.Appointment;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookAppointmentResponse {
    private String message;
    private String id;
}
