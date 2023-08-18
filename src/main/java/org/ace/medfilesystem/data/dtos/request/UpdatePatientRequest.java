package org.ace.medfilesystem.data.dtos.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.medfilesystem.data.models.Gender;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePatientRequest {
    private String imageUrl;
    private String dateOfBirth;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
