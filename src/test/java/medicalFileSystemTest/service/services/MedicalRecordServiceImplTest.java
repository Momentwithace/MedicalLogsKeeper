package medicalFileSystemTest.service.services;

import org.ace.medfilesystem.data.dtos.request.AddRecordRequest;
import org.ace.medfilesystem.data.dtos.response.AddRecordResponse;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.service.medicalRecords.MedicalRecordService;
import org.ace.medfilesystem.service.patients.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicalRecordServiceImplTest {
//    @Autowired
//    private MedicalRecordService medicalRecordService;
//
//    @Autowired
//    private PatientService patientService;
//
//    AddRecordResponse response;
//
//    @BeforeEach
//    void setUp() throws MedicalFileSystemException {
//        patientService.registerPatient(
//                new RegisterPatientRequest("Michael", "Boyo",
//                        "09-10-1995", "testmail@mail.com", "estPassword123")
//        );
//        response = medicalRecordService.addRecord(
//                new AddRecordRequest(1L, 123.5, "well", "celsius")
//        );
//    }
//
//    @Test
//    void addRecord() {
//        assertEquals("record added successfully", response.getMessage());
//    }
//
//    @Test
//    void getPatientMedicalRecord() {
//        assertEquals(1, medicalRecordService.getPatientMedicalRecord(1L).size());
//    }
}