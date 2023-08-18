package medicalFileSystemTest.service.services;

import com.med.healthrecords.data.dataTransferObjects.requests.AddRecordRequest;
import com.med.healthrecords.data.dataTransferObjects.requests.RegisterPatientRequest;
import com.med.healthrecords.data.dataTransferObjects.responses.AddRecordResponse;
import com.med.healthrecords.exceptions.PatientNotFoundException;
import com.med.healthrecords.services.medicalRecords.MedicalRecordService;
import com.med.healthrecords.services.patients.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicalRecordServiceImplTest {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private PatientService patientService;

    AddRecordResponse response;

    @BeforeEach
    void setUp() throws PatientNotFoundException {
        patientService.registerPatient(
                new RegisterPatientRequest("Michael", "Boyo",
                        "09-10-1995", "testmail@mail.com", "estPassword123")
        );
        response = medicalRecordService.addRecord(
                new AddRecordRequest(1L, 123.5, "well", "celsius")
        );
    }

    @Test
    void addRecord() {
        assertEquals("record added successfully", response.getMessage());
    }

    @Test
    void getPatientMedicalRecord() {
        assertEquals(1, medicalRecordService.getPatientMedicalRecord(1L).size());
    }
}