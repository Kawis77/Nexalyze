package com.nexalyze.nexalyze.organization.model;

import com.nexalyze.nexalyze.validation.user.ValidUserEmail;
import com.nexalyze.nexalyze.validation.user.ValidUserName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationModel {

        @NotBlank(message = "Username must not be blank")
        @ValidUserName
        private String userName;

        @NotBlank(message = "First name must not be blank")
        private String firstName;

        @NotBlank(message = "Surname must not be blank")
        private String surname;

        @NotBlank(message = "Email must not be blank")
        @Email(message = "Email format is invalid")
        @ValidUserEmail
        private String email;

        @NotBlank(message = "Password must not be blank")
        private String password;

        @NotBlank(message = "Repeated password must not be blank")
        private String repeatPassword;

        @NotBlank(message = "Organization name must not be blank")
        private String organizationName;

        @NotNull(message = "License must not be null")
        private Integer license;

    public OrganizationModel(String userName, String firstName, String surname, String email, String password, String repeatPassword, String organizationName, Integer license) {
        this.userName = userName;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.organizationName = organizationName;
        this.license = license;
    }
}
