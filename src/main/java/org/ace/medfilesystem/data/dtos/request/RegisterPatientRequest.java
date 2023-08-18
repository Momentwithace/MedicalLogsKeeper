package org.ace.medfilesystem.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterPatientRequest {
    private String firstName;
//    private String lastName;
//    private String email;
//    private String dateOfBirth;
//    private String password;
////    public String getFirstName() {
////        return firstName;
////    }
//
////    public void setFirstName(String firstName) {
////        this.firstName = firstName;
////    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public RegisterPatientRequest(String firstName, String lastName, String dateOfBirth, String email, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//        this.email = email;
//        this.password = password;
//    }

    private String lastName;
    private String dateOfBirth;
    private String email;
    private String password;
}
