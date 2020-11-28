package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.dto.RoomTypeDto;
import com.example.ProjectTogether.persistance.model.RoomTypeModel;
import com.example.ProjectTogether.repository.RoomTypeRepository;
import com.example.ProjectTogether.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/roomType")
    public void addRoomType(@RequestBody RoomTypeDto roomTypeDto) {
        roomTypeService.save(roomTypeDto);
    }

    @DeleteMapping("/roomType/{id}")
    public void deleteRoomType(@PathVariable(name = "id") Long id) {
        roomTypeService.delete(id);
    }

    @GetMapping("/roomType")
    public List<RoomTypeDto> getRoomType() {
      return roomTypeService.getAll();
    }

    @GetMapping("/roomType/{id}")
    public RoomTypeDto getById(@PathVariable(name = "id") Long id) {
        return roomTypeService.getOne(id);
    }
    @PutMapping("/roomType")
    public void updateRoomType(@RequestBody RoomTypeDto roomTypeDto) {
        roomTypeService.update(roomTypeDto);
    }
}
