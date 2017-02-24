package com.sosbt.raktarkezelesi.rendszer.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Viktor on 2017.02.20..
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_password")
    private String password;
    private String userRole;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

}
