package com.example.ProjectTogether.persistance.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reservationf")
public class ReservationFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date date;
    private String firstName;
    private String lastName;
    private String documentId;
    @Enumerated(EnumType.STRING)
    @JsonIgnoreProperties("reservationf")
    @ElementCollection(targetClass = Luggage.class)
    private List<Luggage> luggage;
    @OneToOne( fetch = FetchType.LAZY)
    @JsonIgnoreProperties("reservation")
    private SeatModel seat;

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

    public SeatModel getSeat() {
        return seat;
    }

    public void setSeat(SeatModel seat) {
        this.seat = seat;
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

    public List<Luggage> getLuggage() {
        return luggage;
    }

    public void setLuggage(List<Luggage> luggage) {
        this.luggage = luggage;
    }
}
