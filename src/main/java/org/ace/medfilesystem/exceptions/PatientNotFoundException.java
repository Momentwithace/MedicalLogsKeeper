package org.ace.medfilesystem.exceptions;

public class PatientNotFoundException extends Exception {
    public PatientNotFoundException(){}
    public PatientNotFoundException(String message){
        super(message);
    }

}
