package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.RoomTypeDto;
import com.example.ProjectTogether.persistance.model.RoomTypeModel;
import com.example.ProjectTogether.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public void save(RoomTypeDto roomTypeDto){
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setDescription(roomTypeDto.getDescription());
        roomTypeModel.setHasbalcony(roomTypeDto.isHasbalcony());
        roomTypeModel.setId(roomTypeDto.getId());
        roomTypeModel.setName(roomTypeDto.getName());
        roomTypeModel.setProcentPrice(roomTypeDto.getProcentPrice());
        roomTypeRepository.save(roomTypeModel);
    }

    public void delete(long id){
        roomTypeRepository.deleteById(id);
    }

    public void update(RoomTypeDto roomTypeDto){
        Optional<RoomTypeModel> roomTypeModelOptional = roomTypeRepository.findById(roomTypeDto.getId());
        if (roomTypeModelOptional.isPresent()){
            RoomTypeModel roomTypeModel = roomTypeModelOptional.get();
            roomTypeModel.setDescription(roomTypeDto.getDescription());
            roomTypeModel.setHasbalcony(roomTypeDto.isHasbalcony());
            roomTypeModel.setId(roomTypeDto.getId());
            roomTypeModel.setName(roomTypeDto.getName());
            roomTypeModel.setProcentPrice(roomTypeDto.getProcentPrice());
            roomTypeRepository.save(roomTypeModel);
        }
    }

    public List<RoomTypeDto> getAll(){
        List<RoomTypeModel> roomTypeModels = roomTypeRepository.findAll();
        List<RoomTypeDto> roomTypeDtos = new ArrayList<>();
        for (RoomTypeModel roomTypeModel: roomTypeModels){
            RoomTypeDto roomTypeDto = new RoomTypeDto();
            roomTypeDto.setDescription(roomTypeModel.getDescription());
            roomTypeDto.setHasbalcony(roomTypeModel.isHasbalcony());
            roomTypeDto.setId(roomTypeModel.getId());
            roomTypeDto.setName(roomTypeModel.getName());
            roomTypeDto.setPlaces(roomTypeModel.getPlaces());
            roomTypeDto.setProcentPrice(roomTypeModel.getProcentPrice());
            roomTypeDtos.add(roomTypeDto);
        }
        return roomTypeDtos;
    }

    public RoomTypeDto getOne(long id){
        Optional<RoomTypeModel> roomTypeModelOptional = roomTypeRepository.findById(id);
        RoomTypeDto roomTypeDto = new RoomTypeDto();
        if (roomTypeModelOptional.isPresent()){
            RoomTypeModel roomTypeModel = roomTypeModelOptional.get();
            roomTypeDto.setDescription(roomTypeModel.getDescription());
            roomTypeDto.setHasbalcony(roomTypeModel.isHasbalcony());
            roomTypeDto.setId(roomTypeModel.getId());
            roomTypeDto.setName(roomTypeModel.getName());
            roomTypeDto.setPlaces(roomTypeModel.getPlaces());
            roomTypeDto.setProcentPrice(roomTypeModel.getProcentPrice());
        }
        return roomTypeDto;
    }
}
