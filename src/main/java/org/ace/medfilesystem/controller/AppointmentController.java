package org.ace.medfilesystem.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.ace.medfilesystem.data.dtos.request.BookAppointmentRequest;
import org.ace.medfilesystem.data.dtos.request.RescheduleAppointmentRequest;
import org.ace.medfilesystem.data.dtos.response.*;
import org.ace.medfilesystem.exceptions.MedicalFileSystemException;
import org.ace.medfilesystem.message.success.SuccessMessage;
import org.ace.medfilesystem.service.appointment.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/appointment/")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public BaseResponse<BookAppointmentResponse> bookAppointment(@RequestBody @Valid BookAppointmentRequest request) throws MedicalFileSystemException {
        BookAppointmentResponse response = appointmentService.bookAppointment(request);
        return BaseResponse.<BookAppointmentResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.CREATED.value())
                .message(SuccessMessage.APPOINTMENT_SUCCESSFULLY_BOOK)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping("view/{patientId}")
    public BaseResponse<AppointmentDetailsResponse> viewAppointment(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        AppointmentDetailsResponse response = appointmentService.viewAppointmentDetails(patientId);
        return BaseResponse.<AppointmentDetailsResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @DeleteMapping("remove/{patientId}")
    public BaseResponse<RemoveAppointmentResponse> removeAppointment(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        RemoveAppointmentResponse response = appointmentService.removeAppointment(patientId);
        return BaseResponse.<RemoveAppointmentResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @PostMapping("reschedule/{appointmentId}")
    public BaseResponse<RescheduleAppointResponse> rescheduleAppointment(@RequestBody RescheduleAppointmentRequest rescheduleAppointmentRequest, @PathVariable("appointmentId") String appointmentId) throws MedicalFileSystemException {
        RescheduleAppointResponse response = appointmentService.rescheduleAppointment(rescheduleAppointmentRequest, appointmentId);
        return BaseResponse.<RescheduleAppointResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }

    @DeleteMapping("cancel/{patientId}")
    public BaseResponse<CancelAppointmentResponse> cancel(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        CancelAppointmentResponse response = appointmentService.cancelAppointment(patientId);
        return BaseResponse.<CancelAppointmentResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }
    @DeleteMapping("delete/{patientId}")
    public BaseResponse<DeleteAppointmentResponse> delete(@PathVariable("patientId") String patientId) throws MedicalFileSystemException {
        DeleteAppointmentResponse response = appointmentService.deleteAppointment(patientId);
        return BaseResponse.<DeleteAppointmentResponse>builder()
                .data(response)
                .isSuccessful(true)
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(SuccessMessage.FOUND)
                .build();
    }
}
