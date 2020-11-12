package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.model.RoomTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeModel, Long> {
}
