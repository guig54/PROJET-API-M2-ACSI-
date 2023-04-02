package org.miage.stageAPI.Entity;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor          // obligatoire si JPA
@Data
public class Geo implements Serializable{
    @Id
    @GeneratedValue
    private UUID id;
    private double latitude;
    private double longitude;

    @OneToMany
    private List<LieuStage> lieuStages;

    // Constructeurs, getters et setters
}
