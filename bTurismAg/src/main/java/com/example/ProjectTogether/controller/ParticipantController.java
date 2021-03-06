package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.model.ParticipantModel;
import com.example.ProjectTogether.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping("/participants")
    public List<ParticipantModel> getAllParticipants() {
        return participantRepository.findAll();
    }


    @GetMapping("/participants/{id}")
    public ParticipantModel getById(@PathVariable(name = "id") Long idParticipant) {
        return participantRepository.findById(idParticipant).orElse(null);
    }


    @PostMapping("/participants")
    public void addParticipant(@RequestBody ParticipantModel participantModel) {
        participantRepository.save(participantModel);
    }

    @PutMapping("/participants")
    public void updateParticipant(@RequestBody ParticipantModel participantModel) {
        ParticipantModel participantModelToBeUpdated = participantRepository.findById(participantModel.getId()).orElse(null);
        participantModelToBeUpdated.setFullname(participantModel.getFullname());
        participantModelToBeUpdated.setMobile(participantModel.getMobile());
        participantModelToBeUpdated.setEmail(participantModel.getEmail());
        participantModelToBeUpdated.setCity(participantModel.getCity());
        participantModelToBeUpdated.setAddress(participantModel.getAddress());
        participantModelToBeUpdated.setCardNumber(participantModel.getCardNumber());
        participantModelToBeUpdated.setCardOwnerName(participantModel.getCardOwnerName());
        participantModelToBeUpdated.setState(participantModel.getState());
        participantModelToBeUpdated.setZipcode(participantModel.getZipcode());
        participantRepository.save(participantModelToBeUpdated);
    }

    @DeleteMapping("/participants/{id}")
    public void deleteParticipant(@PathVariable(name = "id") Long idParticipant){
        participantRepository.deleteById(idParticipant);
    }


}
