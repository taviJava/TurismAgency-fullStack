package com.example.ProjectTogether.persistance.dto;

public class VoucherfDto {
    private long id;
    private String username;
    private ReservationfDto reservationFlight;
    private double totalPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ReservationfDto getReservationFlight() {
        return reservationFlight;
    }

    public void setReservationFlight(ReservationfDto reservationFlightt) {
        reservationFlight = reservationFlightt;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
