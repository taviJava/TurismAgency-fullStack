package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.SeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatModel, Long> {

    List<SeatModel> findAllByFlight_Id(long id);
}
