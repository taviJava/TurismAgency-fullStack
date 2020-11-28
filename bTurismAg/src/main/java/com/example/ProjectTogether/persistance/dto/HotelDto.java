package com.example.ProjectTogether.persistance.dto;

import com.example.ProjectTogether.persistance.model.PhotoHotelModel;
import java.util.List;

public class HotelDto {
    private Long id;
    private String name;
    private int stars;
    private String description;
    private double basicPrice;
    private CityDto cityModel;
    private List<PhotoHotelModel> photos;
    private List<RoomDto> rooms;

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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public CityDto getCityModel() {
        return cityModel;
    }

    public void setCityModel(CityDto city) {
        cityModel = city;
    }

    public List<PhotoHotelModel> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoHotelModel> photos) {
        this.photos = photos;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
