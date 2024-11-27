package com.paryshkin.spring.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)//сохраняется до конца программы
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail
{
    public String value() default "xyz.com";
    public String message() default "email must ends with xyz.com";

    //Еще нужно прописать это:
    public Class<?>[] groups() default {};
    public Class<? extends Payload> [] payload() default {};
}
