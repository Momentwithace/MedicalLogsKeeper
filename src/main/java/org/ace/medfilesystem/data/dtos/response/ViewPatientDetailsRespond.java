package org.ace.medfilesystem.data.dtos.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.ace.medfilesystem.data.models.Gender;

import java.time.LocalDateTime;

public class ViewPatientDetailsRespond {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String imageUrl;
    private String dateOfBirth;
    private String address;
    private Gender gender;
}
