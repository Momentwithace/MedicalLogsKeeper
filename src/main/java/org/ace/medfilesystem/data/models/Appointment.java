package org.ace.medfilesystem.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @UuidGenerator
    private String id;
    private String date;
    @ManyToOne
    private Patient patient;
    private LocalDateTime dateCreated;

}
