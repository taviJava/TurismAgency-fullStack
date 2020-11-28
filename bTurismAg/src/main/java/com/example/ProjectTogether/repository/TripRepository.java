package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.TripModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<TripModel,Long> {
}
