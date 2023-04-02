package org.miage.stageAPI.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Type;
import org.miage.stageAPI.Entity.Candidature;
import org.miage.stageAPI.Entity.OffreStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, UUID> {
@Query("SELECT o.id FROM OffreStage o JOIN o.candidat c WHERE c.id = :idCandidature")
List<UUID> findIdsOffreStageByIdCandidature(@Param("idCandidature") UUID idCandidature);
}
