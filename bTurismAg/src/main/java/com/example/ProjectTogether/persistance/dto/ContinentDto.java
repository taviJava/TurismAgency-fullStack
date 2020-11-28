package com.example.ProjectTogether.persistance.dto;

import java.util.List;

public class ContinentDto {
    private Long id;
    private String name;
    private List<CountryDto> countryModelList;

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

    public List<CountryDto> getCountryModelList() {
        return countryModelList;
    }

    public void setCountryModelList(List<CountryDto> countryModelList) {
        this.countryModelList = countryModelList;
    }
}
