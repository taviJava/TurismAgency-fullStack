package com.example.ProjectTogether.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RoomType")
public class RoomTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private int places;
    private boolean hasbalcony;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomTypeModel", orphanRemoval = false)
    @JsonIgnoreProperties("roomTypeModel")
    private List<RoomModel> roomModelList;

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

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public List<RoomModel> getRoomModelList() {
        return roomModelList;
    }

    public void setRoomModelList(List<RoomModel> roomModelList) {
        this.roomModelList = roomModelList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasbalcony() {
        return hasbalcony;
    }

    public void setHasbalcony(boolean hasbalcony) {
        this.hasbalcony = hasbalcony;
    }
}
