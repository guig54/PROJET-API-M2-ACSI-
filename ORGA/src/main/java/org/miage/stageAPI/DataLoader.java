/*package org.miage.stageAPI;


import java.util.ArrayList;

import org.miage.stageAPI.Entity.Role;
import org.miage.stageAPI.Entity.Utilisateur;
import org.miage.stageAPI.Repository.RoleRepository;
import org.miage.stageAPI.Repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UtilisateurRepository userRepository;
    private final RoleRepository roleRepository;

    public DataLoader(UtilisateurRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role("UTILISATEUR");
        Role roleEntreprise = new Role("ENTREPRISE");

        roleRepository.save(roleUser);
        roleRepository.save(roleEntreprise);

        Utilisateur user = new Utilisateur();

        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(roleUser);
        user.setRoles(roles);

        userRepository.save(user);
    }
}*/
