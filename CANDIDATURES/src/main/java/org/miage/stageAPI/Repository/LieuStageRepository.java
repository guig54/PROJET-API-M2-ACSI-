package org.miage.stageAPI.Repository;

import java.util.UUID;

import org.miage.stageAPI.Entity.LieuStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuStageRepository extends JpaRepository<LieuStage, UUID> {
} 