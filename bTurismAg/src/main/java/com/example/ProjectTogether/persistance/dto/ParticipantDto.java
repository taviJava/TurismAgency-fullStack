package com.example.ProjectTogether.persistance.dto;

import java.util.List;

public class ParticipantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;
    private String Address;
    private List<TripDto> tripModels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<TripDto> getTripModels() {
        return tripModels;
    }

    public void setTripModels(List<TripDto> tripModels) {
        this.tripModels = tripModels;
    }
}
