package io.kapil.springdemo.forms.validation.customFormValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 4:22 pm
 */

public class CourseCodeCustomValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        this.coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        if (courseCode != null && courseCode.length() > 5) {
            return courseCode.startsWith(this.coursePrefix);
        }
        return false;
    }
}
