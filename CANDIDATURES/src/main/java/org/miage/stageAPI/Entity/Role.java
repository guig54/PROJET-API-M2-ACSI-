/* package org.miage.stageAPI.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    private String name="";



    @ManyToMany
    private List<Utilisateur> Users;
    
    public Role(){
        
    }
    public Role(String nomRole){
        name=nomRole;
        Users=new ArrayList<Utilisateur>();
    }
   


} */