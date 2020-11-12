package com.example.ProjectTogether.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cities")
public class CityModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnoreProperties("cityModelList")
  private CountryModel countryModel;


  @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityModel", orphanRemoval = false)
  @JsonIgnoreProperties("cityModel")
  private List<HotelModel> hotelModelList;

  @OneToOne(mappedBy = "cityModel")
  @JsonIgnoreProperties("cityModel")
  private AirportModel airportModel;

  public CityModel() {
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

  public CountryModel getCountryModel() {
    return countryModel;
  }

  public void setCountryModel(CountryModel countryModel) {
    this.countryModel = countryModel;
  }

  public List<HotelModel> getHotelModelList() {
    return hotelModelList;
  }

  public void setHotelModelList(List<HotelModel> hotelModelList) {
    this.hotelModelList = hotelModelList;
  }

  public AirportModel getAirportModel() {
    return airportModel;
  }

  public void setAirportModel(AirportModel airportModel) {
    this.airportModel = airportModel;
  }

}
