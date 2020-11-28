package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.CityDto;
import com.example.ProjectTogether.persistance.dto.HotelDto;
import com.example.ProjectTogether.persistance.model.CityModel;
import com.example.ProjectTogether.persistance.model.HotelModel;
import com.example.ProjectTogether.repository.CityRepository;
import com.example.ProjectTogether.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CityRepository cityRepository;

    public void save(HotelDto hotelDto){
        HotelModel hotelModel = new HotelModel();
        hotelModel.setBasicPrice(hotelDto.getBasicPrice());
        hotelModel.setDescription(hotelDto.getDescription());
        hotelModel.setName(hotelDto.getName());
        hotelModel.setStars(hotelDto.getStars());
        Optional<CityModel> cityModelOptional = cityRepository.findById(hotelDto.getCityModel().getId());
        if (cityModelOptional.isPresent()){
            CityModel cityModel = cityModelOptional.get();
            hotelModel.setCityModel(cityModel);
        }
        hotelRepository.save(hotelModel);
    }
    public  void update (HotelDto hotelDto){
        Optional<HotelModel> hotelModelOptional = hotelRepository.findById(hotelDto.getId());
        if (hotelModelOptional.isPresent()){
            HotelModel hotelModel = hotelModelOptional.get();
            hotelModel.setBasicPrice(hotelDto.getBasicPrice());
            hotelModel.setDescription(hotelDto.getDescription());
            hotelModel.setName(hotelDto.getName());
            hotelModel.setStars(hotelDto.getStars());
            Optional<CityModel> cityModelOptional = cityRepository.findById(hotelDto.getCityModel().getId());
            if (cityModelOptional.isPresent()){
                CityModel cityModel = cityModelOptional.get();
                hotelModel.setCityModel(cityModel);
            }
            hotelRepository.save(hotelModel);
        }
    }

    public void delete(long id){
        hotelRepository.deleteById(id);
    }

    public List<HotelDto> getAll(){
        List<HotelModel> hotelModels = hotelRepository.findAll();
        List<HotelDto> hotelDtos = new ArrayList<>();
        for (HotelModel hotelModel: hotelModels){
            HotelDto hotelDto = new HotelDto();
            hotelDto.setId(hotelModel.getId());
            hotelDto.setBasicPrice(hotelModel.getBasicPrice());
            hotelDto.setDescription(hotelModel.getDescription());
            hotelDto.setName(hotelModel.getName());
            hotelDto.setStars(hotelModel.getStars());
            CityDto cityDto = new CityDto();
            cityDto.setName(hotelModel.getCityModel().getName());
            cityDto.setId(hotelModel.getCityModel().getId());
            hotelDto.setCityModel(cityDto);
            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }
    public HotelDto getOne(long id){
        Optional<HotelModel> hotelModelOptional = hotelRepository.findById(id);
        HotelDto hotelDto = new HotelDto();
        if(hotelModelOptional.isPresent()){
            HotelModel hotelModel = hotelModelOptional.get();
            hotelDto.setId(hotelModel.getId());
            hotelDto.setBasicPrice(hotelModel.getBasicPrice());
            hotelDto.setDescription(hotelModel.getDescription());
            hotelDto.setName(hotelModel.getName());
            hotelDto.setStars(hotelModel.getStars());
            CityDto cityDto = new CityDto();
            cityDto.setName(hotelModel.getCityModel().getName());
            cityDto.setId(hotelModel.getCityModel().getId());
            hotelDto.setCityModel(cityDto);
        }
        return hotelDto;
    }
}
