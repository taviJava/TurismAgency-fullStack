package com.example.ProjectTogether.repository;


import com.example.ProjectTogether.model.AirportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportModel, Long> {
}
