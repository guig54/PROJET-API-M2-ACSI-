package org.miage.stageAPI.Repository;

import java.util.List;
import java.util.UUID;

import org.miage.stageAPI.Entity.OffreStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreStageRepository extends JpaRepository<OffreStage, UUID> {
    
}