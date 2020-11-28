package com.example.ProjectTogether.service;

import com.example.ProjectTogether.persistance.dto.ContinentDto;
import com.example.ProjectTogether.persistance.model.ContinentModel;
import com.example.ProjectTogether.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    public void save(ContinentDto continentDto){
        ContinentModel continentModel = new ContinentModel();
        continentModel.setName(continentDto.getName());
        continentRepository.save(continentModel);
    }
    public void update(ContinentDto continentDto){
        Optional<ContinentModel> optionalContinentModel = continentRepository.findById(continentDto.getId());
        if (optionalContinentModel.isPresent()){
            ContinentModel continentModel = optionalContinentModel.get();
            continentModel.setName(continentDto.getName());
            continentRepository.save(continentModel);
        }
    }
    public void delete(long id){
        continentRepository.deleteById(id);
    }
    public List<ContinentDto> getAll(){
        List<ContinentModel> continentModels = continentRepository.findAll();
        List<ContinentDto> continentDtos = new ArrayList<>();
        for (ContinentModel continentModel: continentModels){
            ContinentDto continentDto = new ContinentDto();
            continentDto.setId(continentModel.getId());
            continentDto.setName(continentModel.getName());
            continentDtos.add(continentDto);
        }
        return continentDtos;
    }
    public ContinentDto getContinent(long id){
        Optional<ContinentModel> continentModelOptional = continentRepository.findById(id);
        ContinentDto continentDto = new ContinentDto();
        if (continentModelOptional.isPresent()){
            ContinentModel continentModel = continentModelOptional.get();
            continentDto.setId(continentModel.getId());
            continentDto.setName(continentModel.getName());
        }
        return continentDto;
    }
}
