package com.example.ProjectTogether.persistance.dto;

import java.util.ArrayList;
import java.util.List;

public class CityDto {
    private Long id;
    private String name;
    private CountryDto countryModel;
    private List<HotelDto> hotelModelList = new ArrayList<>();
    private AirportDto airportModel;

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

    public CountryDto getCountryModel() {
        return countryModel;
    }

    public void setCountryModel(CountryDto country) {
        countryModel = country;
    }

    public List<HotelDto> getHotelModelList() {
        return hotelModelList;
    }

    public void setHotelModelList(List<HotelDto> hotels) {
        this.hotelModelList = hotels;
    }

    public AirportDto getAirportModel() {
        return airportModel;
    }

    public void setAirportModel(AirportDto airport) {
        airportModel = airport;
    }
}
