package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.VoucherH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherHRepository extends JpaRepository<VoucherH, Long> {
}
