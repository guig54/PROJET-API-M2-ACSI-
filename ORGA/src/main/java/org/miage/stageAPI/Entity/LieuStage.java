package org.miage.stageAPI.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor          // obligatoire si JPA
@Data
public class LieuStage  extends RepresentationModel<OffreStage> implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Adresse adresse;
    @ManyToOne
    private Geo geo;
    private String telephone;
    private String url;

    // Constructeurs, getters et setters
}  