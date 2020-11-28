package com.example.ProjectTogether.repository;
import com.example.ProjectTogether.persistance.model.ReservationHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationHotelRepository extends JpaRepository<ReservationHotel,Long> {
}
