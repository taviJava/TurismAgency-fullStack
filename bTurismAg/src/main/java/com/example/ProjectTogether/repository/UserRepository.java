package com.example.ProjectTogether.repository;

import com.example.ProjectTogether.persistance.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel , Long> {
    public Optional<UserModel> getUserModelByUsername(String userName);
}
