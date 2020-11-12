package com.example.ProjectTogether.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Hotels")
public class HotelModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private int stars;
  private String description;
  private String paket;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnoreProperties("hotelModelList")
  private CityModel cityModel;

  @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "hotel")
  @JsonIgnoreProperties("hotel")
  private List<PhotoHotelModel> photos;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", orphanRemoval = false)
  @JsonIgnoreProperties("hotel")
 private List<RoomModel> rooms;
  public HotelModel() {
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


  public CityModel getCityModel() {
    return cityModel;
  }

  public String getPaket() {
    return paket;
  }

  public void setPaket(String paket) {
    this.paket = paket;
  }

  public void setCityModel(CityModel cityModel) {
    this.cityModel = cityModel;
  }

  public List<PhotoHotelModel> getPhotos() {
    return photos;
  }

  public void setPhotos(List<PhotoHotelModel> photos) {
    this.photos = photos;
  }

  public List<RoomModel> getRooms() {
    return rooms;
  }

  public void setRooms(List<RoomModel> rooms) {
    this.rooms = rooms;
  }
}
