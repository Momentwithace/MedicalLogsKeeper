package org.ace.medfilesystem.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    @Id
    @UuidGenerator
    private String id;
    private Double temperature;
    private String diagnosis;
    private String temperatureUnit;
    private String bloodPressureResult;
    private Boolean isArchived;
    @ManyToOne
    private Patient recordHolder;
    private LocalDateTime datedCreated;
    private LocalDateTime dateUpdated;
}
