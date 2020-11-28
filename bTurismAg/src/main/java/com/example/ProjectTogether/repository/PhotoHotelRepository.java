package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.PhotoHotelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoHotelRepository extends JpaRepository<PhotoHotelModel,String> {
}
