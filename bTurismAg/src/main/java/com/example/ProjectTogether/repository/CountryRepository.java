package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel,Long> {
}
