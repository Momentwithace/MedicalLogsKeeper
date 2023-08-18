package org.ace.medfilesystem.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    @Id
    @UuidGenerator
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
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
