package com.example.abc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Role extends Common{

    private String name;

    @ManyToOne
    private User user;
}
