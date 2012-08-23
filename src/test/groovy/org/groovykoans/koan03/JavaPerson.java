package org.groovykoans.koan03;

import java.io.Serializable;

/**
 * A simple POJO (Plain Old Java Object) representing a person.
 * First and last name can be modified, but ssn is forever.
 */
public class JavaPerson implements Serializable {

    private String firstName;
    private String lastName;
    private final String ssn;

    public JavaPerson(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    // ------------ START EDITING HERE ----------------------
    public String getFirstName() {
        return firstName;
    }
    // ------------ STOP EDITING HERE  ----------------------

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     // Since ssn cannot be modified, we only have a getter for this field
    public String getSsn() {
        return ssn;
    }
}
