package org.ace.medfilesystem.data.dtos.request;

public class AddRecordRequest {
    private Long patientId;
     private Double temperature;
    private String diagnosis;
    private String temperatureUnit;

    public AddRecordRequest(long patientId, Double temperature, String diagnosis, String temperatureUnit) {
        this.patientId = patientId;
        this.temperature = temperature;
        this.diagnosis = diagnosis;
        this.temperatureUnit = temperatureUnit;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
