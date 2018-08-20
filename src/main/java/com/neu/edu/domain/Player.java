package com.neu.edu.domain;

public class Player {

    private final String id;
    private final String firstname;
    private final String lastname;
    private final String country;
    private final String position;

    public Player(String id, String firstname, String lastname, String country, String position) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCountry() {
        return country;
    }

    public String getPosition() {
        return position;
    }
}
