package com.example.ProjectTogether.repository;


import com.example.ProjectTogether.persistance.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightModel, Long> {
}
