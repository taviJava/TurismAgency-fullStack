package com.example.ProjectTogether.persistance.dto;


import java.sql.Date;
import java.util.List;

public class ReservationfDto {
    private long id;
    private Date date;
    private String firstName;
    private String lastName;
    private String documentId;
    private List<String> luggage;
    private SeatDto seat;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public List<String> getLuggage() {
        return luggage;
    }

    public void setLuggage(List<String> luggage) {
        this.luggage = luggage;
    }

    public SeatDto getSeat() {
        return seat;
    }

    public void setSeat(SeatDto seatt) {
        seat = seatt;
    }
}
