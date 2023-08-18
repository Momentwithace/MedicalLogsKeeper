package org.ace.medfilesystem.data.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.medfilesystem.data.models.MedicalRecord;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddRecordResponse {
    private String message;
    private List<MedicalRecord> records;


}
