package org.ace.medfilesystem.data.dtos.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddRecordRequest {
    private Long patientId;
    private Double temperature;
    private String diagnosis;
    private String temperatureUnit;

}
