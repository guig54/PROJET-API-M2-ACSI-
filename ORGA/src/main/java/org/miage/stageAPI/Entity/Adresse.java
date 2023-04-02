package org.miage.stageAPI.Entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.hateoas.RepresentationModel;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor          // obligatoire si JPA
@Data
public class Adresse extends RepresentationModel<Adresse>  implements Serializable{
    @Id
    @GeneratedValue
    private UUID id;

    private String adressePays;
    private String adresseVille;
    private String codePostal;
    private String adresseRue;

    // Constructeurs, getters et setters
}
