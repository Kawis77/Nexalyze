package com.nexalyze.nexalyze.validation.user;

import com.nexalyze.nexalyze.organization.model.OrganizationModel;
import com.nexalyze.nexalyze.user.model.OrganizationUser;
import com.nexalyze.nexalyze.user.service.OrganizationUserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEmailValidator implements ConstraintValidator<ValidUserEmail , String> {
    @Autowired
    OrganizationUserService organizationUserService;
    @Override
    public void initialize(ValidUserEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        OrganizationUser organizationUser = organizationUserService.getUserByEmail(email);
        if (organizationUser != null) {
            return false;
        }
        return true;
    }
}
