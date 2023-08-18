package org.ace.medfilesystem.data.dtos.response;

import com.med.healthrecords.data.models.MedicalRecord;

import java.util.List;

public class AddRecordResponse {
    private String message;
    private List<MedicalRecord> records;

    public List<MedicalRecord> getRecords() {
        return records;
    }

    public void setRecords(List<MedicalRecord> records) {
        this.records = records;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AddRecordResponse(String message, List<MedicalRecord> records) {
        this.message = message;
        this.records = records;
    }
}
