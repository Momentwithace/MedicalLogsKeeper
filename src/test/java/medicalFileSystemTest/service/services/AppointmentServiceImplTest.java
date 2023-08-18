package medicalFileSystemTest.service.services;

import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.data.dtos.request.RegisterPatientRequest;
import org.ace.medfilesystem.data.dtos.response.BookAppointmentResponse;
import org.ace.medfilesystem.exceptions.PatientNotFoundException;
import org.ace.medfilesystem.service.appointment.AppointmentService;
import org.ace.medfilesystem.service.patients.PatientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentServiceImplTest {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    BookAppointmentResponse response;

    @BeforeEach
    void setUp() throws PatientNotFoundException {
        patientService.registerPatient(
                new RegisterPatientRequest("John", "Doe",
                        "09-10-1996", "test@gmail.com",
                        "WeakPassword123")
        );
        response = appointmentService.bookAppointment(
                new BookAppointmentRequest(1L)
        );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void bookAppointment() {
        assertEquals("Appointment booked successfully",
                response.getMessage());

    }

    @Test
    void getPatientAppointments() {
        assertEquals(1, appointmentService.getPatientAppointments(1L).size());
    }
}