package com.nexalyze.nexalyze.user.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;
import static com.nexalyze.nexalyze.configuration.constans.DbConstants.*;

@Entity
@Table(name = TABLE_USER)
public class OrganizationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = TABLE_USER_COLUMN_USERNAME)
    private String username;
    @Column(name = TABLE_USER_COLUMN_PASSWORD)
    private String password;
    @Column(name = TABLE_USER_COLUMN_FIRST_NAME)
    private String firstname;
    @Column(name = TABLE_USER_COLUMN_SECOND_NAME)
    private String secondname;
    @Column(name = TABLE_USER_COLUMN_SURNAME)
    private String surname;
    @Column(name = TABLE_USER_COLUMN_EMAIL)
    private String email;
    @Column(name = TABLE_USER_COLUMN_ORGANIZATION_ID)
    private Long organizationId;
    @Column(name = TABLE_USER_COLUMN_ROLE)
    private String role;


    public OrganizationUser() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}
