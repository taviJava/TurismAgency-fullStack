package com.example.ProjectTogether.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class CountryModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;


  @ManyToOne(fetch = FetchType.EAGER)
  @JsonIgnoreProperties("countryModelList")
  private ContinentModel continentModel;

//  @OneToMany(fetch = FetchType.LAZY, mappedBy = "countryModel", orphanRemoval = false)
//  @JsonIgnoreProperties("countryModel")
//  private List<CityModel> cityModelList;




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

  public ContinentModel getContinentModel() {
    return continentModel;
  }

  public void setContinentModel(ContinentModel continentModel) {
    this.continentModel = continentModel;
  }

//  public List<CityModel> getCityModelList() {
//    return cityModelList;
//  }
//
//  public void setCityModelList(List<CityModel> cityModelList) {
//    this.cityModelList = cityModelList;
//  }
}
