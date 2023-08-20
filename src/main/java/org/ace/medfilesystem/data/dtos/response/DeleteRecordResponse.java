package org.ace.medfilesystem.data.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor@NoArgsConstructor
public class DeleteRecordResponse {
    private String message;
    private LocalDateTime dateDeleted;
    private String id;
}
