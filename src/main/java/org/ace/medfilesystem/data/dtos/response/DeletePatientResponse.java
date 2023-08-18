package org.ace.medfilesystem.data.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class DeletePatientResponse {
    private String message;
    private String courseId;
    private LocalDateTime dateDelete;
}
