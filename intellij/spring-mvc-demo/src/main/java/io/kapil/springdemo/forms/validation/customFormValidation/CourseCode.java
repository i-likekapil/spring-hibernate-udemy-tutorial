package io.kapil.springdemo.forms.validation.customFormValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 4:21 pm
 */


@Constraint(validatedBy = CourseCodeCustomValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    String value() default "LUV";

    String message() default "Course code must start with LUV and length should be more than 5";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
