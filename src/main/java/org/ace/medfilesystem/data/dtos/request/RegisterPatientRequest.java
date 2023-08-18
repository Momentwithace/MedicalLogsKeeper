package org.ace.medfilesystem.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterPatientRequest {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String password;
}
