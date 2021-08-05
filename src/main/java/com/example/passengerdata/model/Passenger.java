package com.example.passengerdata.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passportid")
    private long passportID;

    @Column(name = "email")
    private String email;
}
