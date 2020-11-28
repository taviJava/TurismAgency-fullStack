package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.CityDto;
import com.example.ProjectTogether.persistance.dto.CountryDto;
import com.example.ProjectTogether.persistance.model.CityModel;
import com.example.ProjectTogether.persistance.model.CountryModel;
import com.example.ProjectTogether.repository.CityRepository;
import com.example.ProjectTogether.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    public void save(CityDto cityDto){
        CityModel cityModel = new CityModel();
        cityModel.setName(cityDto.getName());
        Optional<CountryModel> countryModelOptional = countryRepository.findById(cityDto.getCountryModel().getId());
        if (countryModelOptional.isPresent()) {
            CountryModel countryModel = countryModelOptional.get();
            cityModel.setCountryModel(countryModel);
        }
        cityRepository.save(cityModel);
    }
    public void update(CityDto cityDto){
        Optional<CityModel> cityModelOptional = cityRepository.findById(cityDto.getId());
        if (cityModelOptional.isPresent()){
            CityModel cityModel = cityModelOptional.get();
            cityModel.setName(cityDto.getName());
            Optional<CountryModel> countryModelOptional = countryRepository.findById(cityDto.getCountryModel().getId());
            if (countryModelOptional.isPresent()){
                cityModel.setCountryModel(countryModelOptional.get());
            }
            cityRepository.save(cityModel);
        }
    }

    public void delete(long id){
        cityRepository.deleteById(id);
    }
    public List<CityDto> getAll(){
        List<CityModel> cityModels = cityRepository.findAll();
        List<CityDto> cityDtos = new ArrayList<>();
        for (CityModel cityModel: cityModels){
            CityDto cityDto = new CityDto();
            cityDto.setId(cityModel.getId());
            cityDto.setName(cityModel.getName());
            CountryModel countryModel = cityModel.getCountryModel();
            CountryDto countryDto = new CountryDto();
            countryDto.setId(countryModel.getId());
            countryDto.setName(countryModel.getName());
            cityDto.setCountryModel(countryDto);
            cityDtos.add(cityDto);
        }
        return cityDtos;
    }

    public CityDto getOne(long id){
        Optional<CityModel> cityModelOptional = cityRepository.findById(id);
        CityDto cityDto = new CityDto();
        if(cityModelOptional.isPresent()){
            CityModel cityModel = cityModelOptional.get();
            cityDto.setId(cityModel.getId());
            cityDto.setName(cityModel.getName());
            CountryModel countryModel = cityModel.getCountryModel();
            CountryDto countryDto = new CountryDto();
            countryDto.setId(countryModel.getId());
            countryDto.setName(countryModel.getName());
            cityDto.setCountryModel(countryDto);
        }
        return cityDto;
    }
}
