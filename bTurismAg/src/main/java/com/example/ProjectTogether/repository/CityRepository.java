package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {
}
