package org.ace.medfilesystem.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.data.dtos.request.RescheduleAppointmentRequest;
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
    public ResponseEntity<?> bookAppointment(@RequestBody @Valid BookAppointmentRequest request) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.bookAppointment(request));
    }

    @GetMapping("view/{patientId}")
    public ResponseEntity<?> viewAppointment(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.viewAppointmentDetails(patientId));
    }

    @DeleteMapping("remove/{patientId}")
    public ResponseEntity<?> removeAppointment(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.removeAppointment(patientId));
    }

    @PostMapping("reschedule/{appointmentId}")
    public ResponseEntity<?> rescheduleAppointment(@RequestBody RescheduleAppointmentRequest rescheduleAppointmentRequest, @PathVariable("appointmentId") String appointmentId) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.rescheduleAppointment(rescheduleAppointmentRequest, appointmentId));
    }

    @DeleteMapping("cancel/{patientId}")
    public ResponseEntity<?> cancel(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.cancelAppointment(patientId));
    }
    @DeleteMapping("delete/{patientId}")
    public ResponseEntity<?> delete(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        return ResponseEntity.ok(appointmentService.deleteAppointment(patientId));
    }
}
