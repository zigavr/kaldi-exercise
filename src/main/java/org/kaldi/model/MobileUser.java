package org.kaldi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity(name = "mobile_user")
public class MobileUser extends PanacheEntity {

    @NotNull (message = "Designation is missing")
    private String designation;

    @NotEmpty (message = "First name is missing")
    private String firstName;

    @NotEmpty (message = "Last name is missing")
    private String lastName;

    public MobileUser() {}

    public MobileUser(String designation, String firstName, String lastName) {
        this.designation = designation;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
