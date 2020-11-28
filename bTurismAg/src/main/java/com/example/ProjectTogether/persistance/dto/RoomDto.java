package com.example.ProjectTogether.persistance.dto;

import com.example.ProjectTogether.persistance.model.HotelModel;
import com.example.ProjectTogether.persistance.model.ReservationHotel;
import com.example.ProjectTogether.persistance.model.RoomTypeModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class RoomDto {
    private Long id;
    private int number;
    private String description;
    private RoomTypeDto roomTypeModel;
    private HotelDto hotel;
    private List<ReservationhDto> reservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomTypeDto getRoomTypeModel() {
        return roomTypeModel;
    }

    public void setRoomTypeModel(RoomTypeDto roomType) {
        roomTypeModel = roomType;
    }

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotell) {
        hotel = hotell;
    }

    public List<ReservationhDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationhDto> reservations) {
        this.reservations = reservations;
    }
}
