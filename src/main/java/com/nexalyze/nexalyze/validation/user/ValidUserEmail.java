package com.nexalyze.nexalyze.validation.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserEmail {

    String message() default "User with this email already exist in system.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
