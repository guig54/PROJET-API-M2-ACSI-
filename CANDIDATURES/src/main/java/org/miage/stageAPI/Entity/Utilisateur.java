/* package org.miage.stageAPI.Entity;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class Utilisateur implements Serializable{
    @Id
    @GeneratedValue
    private UUID id;
    private String nom;
    private String prenom;



    @ManyToMany
    private List<OffreStage> candidatures;
    @OneToOne
    private OffreStage stage;
    @ManyToMany
    private List<Role> r;

    @PrePersist
    protected void onCreate() {
        r.add(new Role("USER"));
    }
    // Constructeurs, getters et setters

    public void setRoles(ArrayList<Role> roles) {
    }

    
}
 */