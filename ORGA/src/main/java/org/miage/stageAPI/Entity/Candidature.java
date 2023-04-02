package org.miage.stageAPI.Entity;



import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor          // obligatoire si JPA
@Data
public class Candidature {
    @Id
    @GeneratedValue
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID id;
    private String nom;
    private String prenom;
    private String status;

    

    // Constructeurs, getters et setters
}


