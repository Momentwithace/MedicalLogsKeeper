package org.ace.medfilesystem.controller;

import com.med.healthrecords.data.dataTransferObjects.requests.BookAppointmentRequest;
import com.med.healthrecords.exceptions.PatientNotFoundException;
import com.med.healthrecords.services.appointment.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping
    public ResponseEntity<?> bookAppointment(@RequestBody BookAppointmentRequest request) throws PatientNotFoundException {
        return ResponseEntity.ok(appointmentService.bookAppointment(request));
    }
}
