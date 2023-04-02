package org.miage.stageAPI.Entity;



import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.springframework.hateoas.RepresentationModel;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor          // obligatoire si JPA
@Data
public class Candidature extends RepresentationModel<Candidature>  implements Serializable  {
    @Id
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    @GeneratedValue
    private UUID id;
    private String nom;
    private String prenom;
    private String status;

    

    // Constructeurs, getters et setters
}


