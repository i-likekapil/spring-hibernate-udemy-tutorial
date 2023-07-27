package io.kapil.springdemo.forms.validation;

import javax.validation.constraints.NotNull;
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
