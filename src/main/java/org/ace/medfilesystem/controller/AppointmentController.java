package org.ace.medfilesystem.controller;

import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.service.appointment.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment/")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> bookAppointment(@RequestBody BookAppointmentRequest request) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.bookAppointment(request));
    }

    @GetMapping("view")
    public ResponseEntity<?> viewAppointment(@RequestBody String patientId) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.viewAppointmentDetails(patientId));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> removeAppointment(@RequestBody String patientId) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.removeAppointment(patientId));
    }
}
