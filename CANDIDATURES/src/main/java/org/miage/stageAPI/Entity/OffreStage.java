package org.miage.stageAPI.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor          // obligatoire si JPA
@Data
public class OffreStage extends RepresentationModel<OffreStage>  implements Serializable  {
    @Id
    @GeneratedValue
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID id;


    private String nomStage;
    private String domaine;
    private String nomOrganisation;
    private String descriptionStage;

    private Date datePublicationOffre;
    private String niveauEtudesStage;
    private String experienceRequiseStage;
    private Date dateDebutStage;
    private int dureeStage;
    private double salaireStage;
    private boolean indemnisation;
   //TODO 
    private boolean status;
    private int nbPlacesPrises;
    



    
    @ManyToOne
    private Organisation organisation;
    @ManyToOne
    private LieuStage lieuStage;

    @ManyToMany
    private List<Candidature> candidat;
/*     @ManyToMany
    private List<Utilisateur> postulants;
    @OneToOne
    private Utilisateur stagiaire; */

  

    // Constructeurs, getters et setters

    @PrePersist
    protected void onCreate() {
        datePublicationOffre = Calendar.getInstance().getTime();
        status=false;
    }

    protected void onUpdate() {
        nbPlacesPrises ++;
    }


}