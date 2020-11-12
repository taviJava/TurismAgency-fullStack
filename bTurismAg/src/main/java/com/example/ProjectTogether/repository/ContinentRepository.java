package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.model.ContinentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository  extends JpaRepository<ContinentModel,Long> {
}
