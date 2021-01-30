package com.example.abc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusType extends Common{

    private String CLASS;

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }
}
