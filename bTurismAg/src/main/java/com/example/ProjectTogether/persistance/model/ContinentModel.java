package com.example.ProjectTogether.persistance.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "continent")
public class ContinentModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "continentModel", orphanRemoval = false)
  @JsonIgnoreProperties("continentModel")
  private List<CountryModel> countryModelList;

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

  public List<CountryModel> getCountryModelList() {
    return countryModelList;
  }

  public void setCountryModelList(List<CountryModel> countryModelList) {
    this.countryModelList = countryModelList;
  }
}
