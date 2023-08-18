package org.ace.medfilesystem.data.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import org.ace.medfilesystem.constant.regex.RegexPattern;
import org.ace.medfilesystem.constant.validator.Constant;


@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterPatientRequest {
    @Email(message = "Invalid Email Address")
    @NonNull
    private String email;


    @NonNull
    @Pattern(message = "{Pattern.signupRequest.password}", regexp = RegexPattern.PASSWORD_REGEX)
    private String password;


    @NotBlank
    @Pattern(regexp = RegexPattern.STRING_NO_NUMBER_REGEX, message = "{Pattern.signupRequest.name}")
    private String firstName;

    @NotBlank
    @Pattern(regexp = RegexPattern.STRING_NO_NUMBER_REGEX, message = "{Pattern.signupRequest.name}")
    private String lastName;
}
