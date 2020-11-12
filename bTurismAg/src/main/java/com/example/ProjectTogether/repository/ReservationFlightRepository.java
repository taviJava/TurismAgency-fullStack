package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.model.ReservationFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationFlightRepository extends JpaRepository<ReservationFlight,Long> {
}
