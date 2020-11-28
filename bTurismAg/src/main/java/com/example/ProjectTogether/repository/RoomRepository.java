package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel,Long> {
}
