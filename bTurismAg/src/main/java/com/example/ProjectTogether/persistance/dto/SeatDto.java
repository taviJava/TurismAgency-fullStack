package com.example.ProjectTogether.persistance.dto;


public class SeatDto {
    private long id;
    private String seatName;
    private int seatNumber;
    private FlightDto flight;
    private ReservationfDto reservation;

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

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flightt) {
        flight = flightt;
    }

    public ReservationfDto getReservation() {
        return reservation;
    }

    public void setReservation(ReservationfDto reservationn) {
        reservation = reservationn;
    }
}
