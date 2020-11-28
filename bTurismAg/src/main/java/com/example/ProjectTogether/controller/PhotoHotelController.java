package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.persistance.model.HotelModel;
import com.example.ProjectTogether.persistance.model.PhotoHotelModel;
import com.example.ProjectTogether.persistance.model.files.ResponseFile;
import com.example.ProjectTogether.persistance.model.files.ResponseMessage;
import com.example.ProjectTogether.repository.HotelRepository;
import com.example.ProjectTogether.service.PhotoHotelStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class PhotoHotelController {
    @Autowired
    private PhotoHotelStorageService photoHotelStorageService;
    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/photos")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("photo") MultipartFile file) {
        String message;
        try {
            List<HotelModel> hotelModelList = hotelRepository.findAll();
            HotelModel hotelModel = hotelModelList.get(hotelModelList.size()-1);
            photoHotelStorageService.store(file,hotelModel.getId());

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/photos")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = photoHotelStorageService.getAllphotos().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/photos/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/photos/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        PhotoHotelModel photoHotelModel = photoHotelStorageService.getPhoto(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photoHotelModel.getName() + "\"")
                .body(photoHotelModel.getData());
    }
}
