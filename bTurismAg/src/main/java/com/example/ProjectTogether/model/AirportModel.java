package com.example.ProjectTogether.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Airports")
public class AirportModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  @OneToOne(fetch = FetchType.EAGER)
  @JsonIgnoreProperties("airportModel")
  private CityModel cityModel;


  @OneToMany(fetch = FetchType.LAZY, mappedBy = "airportDeparture", orphanRemoval = false)
  @JsonIgnoreProperties("airportDeparture")
  private List<FlightModel> flightDepartures;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "airportArrival", orphanRemoval = false)
  @JsonIgnoreProperties("airportArrival")
  private List<FlightModel> flightArrival;
  public AirportModel() {
  }

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

  public CityModel getCityModel() {
    return cityModel;
  }

  public void setCityModel(CityModel cityModel) {
    this.cityModel = cityModel;
  }

  public List<FlightModel> getFlightDepartures() {
    return flightDepartures;
  }

  public void setFlightDepartures(List<FlightModel> flightDepartures) {
    this.flightDepartures = flightDepartures;
  }

  public List<FlightModel> getFlightArrival() {
    return flightArrival;
  }

  public void setFlightArrival(List<FlightModel> flightArrival) {
    this.flightArrival = flightArrival;
  }
}
