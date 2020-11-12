package com.example.ProjectTogether.repository;
import com.example.ProjectTogether.model.ParticipantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantModel, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM participants WHERE id NOT IN(SELECT participant_models_id FROM trip_model_participant_models WHERE trip_models_id= ?1)")
    Optional<List<ParticipantModel>> getUnassignParticipants(long trip_models_id);
}
