package org.ace.medfilesystem.data.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double temperature;
    private String diagnosis;
    private String temperatureUnit;
    @ManyToOne
    private Patient recordHolder;
}
