package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.VoucherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherModel, Long> {
}
