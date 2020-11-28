package com.example.ProjectTogether.persistance.dto;


public class VoucherhDto {

    private long id;
    private String username;
    private double totalPrice;
    private String firstName;
    private String lastName;
    private String documentId;
    private String packet;
    private ReservationhDto reservationHotel;
    private int numberOfTicketsHotel;

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

    public String getPacket() {
        return packet;
    }

    public void setPacket(String packet) {
        this.packet = packet;
    }

    public ReservationhDto getReservationHotel() {
        return reservationHotel;
    }

    public void setReservationHotel(ReservationhDto reservationHotell) {
        reservationHotel = reservationHotell;
    }

    public int getNumberOfTicketsHotel() {
        return numberOfTicketsHotel;
    }

    public void setNumberOfTicketsHotel(int numberOfTicketsHotel) {
        this.numberOfTicketsHotel = numberOfTicketsHotel;
    }
}
