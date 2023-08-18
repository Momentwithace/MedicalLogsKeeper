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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Double getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(Double temperature) {
//        this.temperature = temperature;
//    }
//
//    public String getDiagnosis() {
//        return diagnosis;
//    }
//
//    public void setDiagnosis(String diagnosis) {
//        this.diagnosis = diagnosis;
//    }
//
//    public String getTemperatureUnit() {
//        return temperatureUnit;
//    }
//
//    public void setTemperatureUnit(String temperatureUnit) {
//        this.temperatureUnit = temperatureUnit;
//    }
//
//    public Patient getRecordHolder() {
//        return recordHolder;
//    }
//
//    public void setRecordHolder(Patient recordHolder) {
//        this.recordHolder = recordHolder;
//    }

    private Double temperature;
    private String diagnosis;
    private String temperatureUnit;
    @ManyToOne
    private Patient recordHolder;
}
