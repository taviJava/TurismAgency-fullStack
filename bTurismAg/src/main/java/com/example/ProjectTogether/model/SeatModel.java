package com.example.ProjectTogether.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="seat")
public class SeatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String seatName;
    private int seatNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("seats")
    private FlightModel flight;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "seat")
    @JsonIgnoreProperties("seat")
    private ReservationFlight reservation;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public FlightModel getFlight() {
        return flight;
    }

    public void setFlight(FlightModel flight) {
        this.flight = flight;
    }

    public ReservationFlight getReservation() {
        return reservation;
    }

    public void setReservation(ReservationFlight reservation) {
        this.reservation = reservation;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
