package medicalFileSystemTest.service.services;

import com.med.healthrecords.data.dataTransferObjects.requests.BookAppointmentRequest;
import com.med.healthrecords.data.dataTransferObjects.requests.RegisterPatientRequest;
import com.med.healthrecords.data.dataTransferObjects.responses.BookAppointmentResponse;
import com.med.healthrecords.exceptions.PatientNotFoundException;
import com.med.healthrecords.services.appointment.AppointmentService;
import com.med.healthrecords.services.patients.PatientService;
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