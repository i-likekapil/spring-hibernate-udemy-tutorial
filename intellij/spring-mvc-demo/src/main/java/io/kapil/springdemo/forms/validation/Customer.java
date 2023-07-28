package io.kapil.springdemo.forms.validation;

import io.kapil.springdemo.forms.validation.customFormValidation.CourseCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 27/07/23
 * @Time 3:15 pm
 */

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 4,message = "last name length should more than 3")
    private String lastName;

    @Min(value = 1, message = "minimum no. of passes is 1")
    @Max(value = 5,message = "no. of passes not more than 5")
    @NotNull(message = "is required")
    private int freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "you enter invalid postal code")
    private String postalCode;

    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
