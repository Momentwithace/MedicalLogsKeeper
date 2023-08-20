package org.ace.medfilesystem.message.success;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SuccessMessage {
    public static final String REGISTRATION_SUCCESSFULLY = "Registration Successfully";
    public static final String UPDATED_MADE_SUCCESSFULLY = "Must Made Successfully";
    public static final String  DELETED = "Deleted Successfully";
    public static final String RECORD_ADDED_SUCCESSFULLY = "record added successfully";
    public static final String ARCHIVED_SUCCESSFULLY = "Archived Successfully";
    public static final String RECORD_REMOVED_SUCCESSFULLY = "Record remove successfully";
    public static final String UNARCHIVED_SUCCESSFULLY = "Unarchive Successful";
    public static final String APPOINTMENT_SUCCESSFULLY_BOOK = "Appointment booked successfully";
    public static final String APPOINTMENT_SUCCESSFULLY_REMOVED ="Appointment removed successfully";
    public static final String APPOINTMENT_SUCCESSFULLY_RESCHEDULED = "Appointment rescheduled";
    public static final String APPOINTMENT_SUCCESSFULLY_CANCELLED = "Appointment successfully cancelled";
    public static final String APPOINTMENT_SUCCESSFULLY_DELETED =  "Appointment successfully deleted";
    public static final String FOUND = "Found";
}
