package com.example.ProjectTogether.service;

import com.example.ProjectTogether.model.HotelModel;
import com.example.ProjectTogether.model.PhotoHotelModel;
import com.example.ProjectTogether.repository.HotelRepository;
import com.example.ProjectTogether.repository.PhotoHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;
@Service
public class PhotoHotelStorageService {
    @Autowired
    private PhotoHotelRepository photoHotelRepository;
    @Autowired
    private HotelRepository hotelRepository;

    public PhotoHotelModel store(MultipartFile file, long id) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        PhotoHotelModel photoHotelModel = new PhotoHotelModel(fileName, file.getContentType(), file.getBytes());
        HotelModel hotelModel = hotelRepository.findById(id).get();
        photoHotelModel.setHotel(hotelModel);
        return photoHotelRepository.save(photoHotelModel);
    }


    public PhotoHotelModel getPhoto(String id) {
        return photoHotelRepository.findById(id).get();
    }

    public Stream<PhotoHotelModel> getAllphotos() {
        return photoHotelRepository.findAll().stream();
    }

    public Stream<PhotoHotelModel> getAllHotelphotos(HotelModel hotelModel) {
        return hotelModel.getPhotos().stream();
    }
}
