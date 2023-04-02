package org.miage.stageAPI.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor          // obligatoire si JPA
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"}) // permet d'ignorer le declanchement d'une erreur et affiche correctement 
public class Organisation  extends RepresentationModel<OffreStage>  implements Serializable{
    @Serial
    @Id
    @GeneratedValue
    private UUID id;
    private String email;
    private String telephone;
    private String url;

    @ManyToOne
    private Adresse adresse;

    @OneToMany
    private List<OffreStage> offres;

    // Constructeurs, getters et setters

    @PrePersist
    protected void onCreate() {
        offres = new ArrayList<OffreStage>();
    }
}
