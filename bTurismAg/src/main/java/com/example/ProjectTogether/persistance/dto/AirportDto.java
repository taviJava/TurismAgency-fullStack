package com.example.ProjectTogether.persistance.dto;
import java.util.List;

public class AirportDto {
    private Long id;
    private String name;
    private CityDto cityModel;
    private List<FlightDto> flightDepartures;
    private List<FlightDto> flightArrival;

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

    public CityDto getCityModel() {
        return cityModel;
    }

    public void setCityModel(CityDto city) {
        cityModel = city;
    }

    public List<FlightDto> getFlightDepartures() {
        return flightDepartures;
    }

    public void setFlightDepartures(List<FlightDto> flightDepartures) {
        this.flightDepartures = flightDepartures;
    }

    public List<FlightDto> getFlightArrival() {
        return flightArrival;
    }

    public void setFlightArrival(List<FlightDto> flightArrival) {
        this.flightArrival = flightArrival;
    }
}
