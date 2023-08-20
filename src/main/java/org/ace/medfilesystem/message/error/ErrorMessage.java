package org.ace.medfilesystem.message.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessage {
    public static final String USER_ALREADY_EXIST = "User Already Exists";

    public static final String USER_WITH_ID_NOT_FOUND = "User with id not found";
    public static final String USER_WITH_EMAIL_NOT_FOUND = "Not Found";
    public static final String  RECORD_NOT_FOUND = "Record not found";
    public static final String RECORD_ALREADY_ARCHIVED = "Record already achived";
    public static final String RECORD_ALREADY_UNARCHIVED = "Record already unarchived";
    public static final String PATIENT_NOT_FOUND = "Patient not found";
    public static final String APPOINTMENT_NOT_FOUND = "Appointment not found";
}
