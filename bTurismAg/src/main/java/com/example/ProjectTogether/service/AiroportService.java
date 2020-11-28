package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.AirportDto;
import com.example.ProjectTogether.persistance.dto.CityDto;
import com.example.ProjectTogether.persistance.model.AirportModel;
import com.example.ProjectTogether.persistance.model.CityModel;
import com.example.ProjectTogether.repository.AirportRepository;
import com.example.ProjectTogether.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AiroportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;

    public void save(AirportDto airportDto){
        AirportModel airportModel = new AirportModel();
        airportModel.setId(airportDto.getId());
        airportModel.setName(airportDto.getName());
        Optional<CityModel> cityModelOptional = cityRepository.findById(airportDto.getCityModel().getId());
        if (cityModelOptional.isPresent()){
            CityModel cityModel = cityModelOptional.get();
            airportModel.setCityModel(cityModel);
        }
        airportRepository.save(airportModel);
    }

    public void update(AirportDto airportDto){
        Optional<AirportModel> airportModelOptional = airportRepository.findById(airportDto.getId());
        if (airportModelOptional.isPresent()){
            AirportModel airportModel = airportModelOptional.get();
            airportModel.setId(airportDto.getId());
            airportModel.setName(airportDto.getName());
            Optional<CityModel> cityModelOptional = cityRepository.findById(airportDto.getCityModel().getId());
            if (cityModelOptional.isPresent()){
                CityModel cityModel = cityModelOptional.get();
                airportModel.setCityModel(cityModel);
            }
            airportRepository.save(airportModel);
        }

    }
    public void delete(long id){
     airportRepository.deleteById(id);
    }

    public List<AirportDto> getAll(){
        List<AirportModel> airportModels = airportRepository.findAll();
        List<AirportDto> airportDtos = new ArrayList<>();
        for (AirportModel airportModel: airportModels){
            AirportDto airportDto = new AirportDto();
            airportDto.setId(airportModel.getId());
            airportDto.setName(airportModel.getName());
            CityDto cityDto = new CityDto();
            cityDto.setId(airportModel.getCityModel().getId());
            cityDto.setName(airportModel.getCityModel().getName());
            airportDto.setCityModel(cityDto);
            airportDtos.add(airportDto);
        }
        return airportDtos;
    }

    public AirportDto getOne(long id){
        Optional<AirportModel> airportModelOptional = airportRepository.findById(id);
        AirportDto airportDto = new AirportDto();
        if (airportModelOptional.isPresent()){
            AirportModel airportModel = airportModelOptional.get();
            airportDto.setId(airportModel.getId());
            airportDto.setName(airportModel.getName());
            CityDto cityDto = new CityDto();
            cityDto.setId(airportModel.getCityModel().getId());
            cityDto.setName(airportModel.getCityModel().getName());
            airportDto.setCityModel(cityDto);
        }
        return airportDto;
    }
}
