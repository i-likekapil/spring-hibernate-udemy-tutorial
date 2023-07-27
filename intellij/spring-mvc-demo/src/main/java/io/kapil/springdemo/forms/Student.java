package io.kapil.springdemo.forms;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 27/07/23
 * @Time 12:39 pm
 */

public class Student {

    private String firstName;
    private String lastName;

    private String country;

    private String programmingLanguage;

    private LinkedHashMap<String,String> countryOptions;

    private String[] operatingSystems;

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student() {

        this.countryOptions = new LinkedHashMap<>();

        this.countryOptions.put("IND","India");
        this.countryOptions.put("6K","Russia");
        this.countryOptions.put("UK","United Kingdom");
        this.countryOptions.put("CH","China");
        this.countryOptions.put("UAE","Dubai");

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

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", countryOptions=" + countryOptions +
                ", operatingSystems=" + Arrays.toString(operatingSystems) +
                '}';
    }
}
