package org.miage.stageAPI.Repository;

import java.util.UUID;

import org.miage.stageAPI.Entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, UUID> {
}