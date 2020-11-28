package com.example.ProjectTogether.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class VoucherH {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private double totalPrice;
    private String firstName;
    private String lastName;
    private String documentId;
    @Enumerated(EnumType.STRING)
    @JsonIgnoreProperties("voucherh")
    private Packet packet;
    @OneToOne(orphanRemoval = true)
    @JsonIgnoreProperties("voucherh")
    private ReservationHotel reservationHotel;
    private int numberOfTicketsHotel;

    public ReservationHotel getReservationHotel() {
        return reservationHotel;
    }

    public void setReservationHotel(ReservationHotel reservationHotel) {
        this.reservationHotel = reservationHotel;
    }

    public int getNumberOfTicketsHotel() {
        return numberOfTicketsHotel;
    }

    public void setNumberOfTicketsHotel(int numberOfTicketsHotel) {
        this.numberOfTicketsHotel = numberOfTicketsHotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
