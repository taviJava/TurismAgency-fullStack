package com.example.ProjectTogether.persistance.dto;


import java.util.ArrayList;
import java.util.List;

public class CountryDto {
    private Long id;
    private String name;
    private ContinentDto continentModel;
    private List<CityDto> cityModelList = new ArrayList<>();

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

    public ContinentDto getContinentModel() {
        return continentModel;
    }

    public void setContinentModel(ContinentDto continent) {
        continentModel = continent;
    }

    public List<CityDto> getCityModelList() {
        return cityModelList;
    }

    public void setCityModelList(List<CityDto> cityModelList) {
        this.cityModelList = cityModelList;
    }
}
