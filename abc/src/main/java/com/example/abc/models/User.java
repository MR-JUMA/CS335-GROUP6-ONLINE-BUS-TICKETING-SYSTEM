package com.example.abc.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends Common{

    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email    ;
    private String MobileNumber;
    @ManyToOne
    private Branch Branch;

    @ManyToMany
    private Set<Role> role;

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public com.example.abc.models.Branch getBranch() {
        return Branch;
    }

    public void setBranch(com.example.abc.models.Branch branch) {
        Branch = branch;
    }
}
