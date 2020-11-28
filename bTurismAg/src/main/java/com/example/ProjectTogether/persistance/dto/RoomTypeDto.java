package com.example.ProjectTogether.persistance.dto;

import java.util.List;

public class RoomTypeDto {
    private Long id;
    private String name;
    private String description;
    private int places;
    private int procentPrice;
    private boolean hasbalcony;
    private List<RoomDto> roomModelList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getProcentPrice() {
        return procentPrice;
    }

    public void setProcentPrice(int procentPrice) {
        this.procentPrice = procentPrice;
    }

    public boolean isHasbalcony() {
        return hasbalcony;
    }

    public void setHasbalcony(boolean hasbalcony) {
        this.hasbalcony = hasbalcony;
    }

    public List<RoomDto> getRoomModelList() {
        return roomModelList;
    }

    public void setRoomModelList(List<RoomDto> roomModelList) {
        this.roomModelList = roomModelList;
    }
}
