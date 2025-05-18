package com.nexalyze.nexalyze.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationUserModel {

    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String email;
    private Long organizationId;
    private String role;


}
