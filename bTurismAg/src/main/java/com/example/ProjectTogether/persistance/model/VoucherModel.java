package com.example.ProjectTogether.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "voucher")
public class VoucherModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("voucher")
    private ReservationFlight reservationFlight;

    private double totalPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ReservationFlight getReservationFlight() {
        return reservationFlight;
    }

    public void setReservationFlight(ReservationFlight reservationFlight) {
        this.reservationFlight = reservationFlight;
    }



    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
