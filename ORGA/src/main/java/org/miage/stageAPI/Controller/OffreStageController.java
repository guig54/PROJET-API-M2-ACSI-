package org.miage.stageAPI.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.miage.stageAPI.Entity.Adresse;
import org.miage.stageAPI.Entity.Candidature;
import org.miage.stageAPI.Entity.Geo;
import org.miage.stageAPI.Entity.LieuStage;
import org.miage.stageAPI.Entity.OffreStage;
import org.miage.stageAPI.Entity.Organisation;
import org.miage.stageAPI.Repository.AdresseRepository;
import org.miage.stageAPI.Repository.GeoRepository;
import org.miage.stageAPI.Repository.LieuStageRepository;
import org.miage.stageAPI.Repository.OffreStageRepository;
import org.miage.stageAPI.Repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping("/api/offres-stage")
public class OffreStageController {



    //declarer tous les repository 
    @Autowired
    private OffreStageRepository offreStageRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private OrganisationRepository organisationRepository;
    @Autowired
    private LieuStageRepository lieuRepository;
    @Autowired
    private GeoRepository geoRepository;

    private UUID tokenOrg=UUID.fromString("c1292121-dfdd-45aa-a31e-1247c6a02677");




    //ajouter une offre au repository
    public void addOffre(OffreStage offre){
        if(offre.getLieuStage()!=null){
            addLieuStage(offre.getLieuStage());
        }
        offreStageRepository.save(offre);
    }

    //ajouter un lieu de stage au repository
    private void addLieuStage(LieuStage lieuStage) {
        if(lieuStage.getAdresse()!=null){
            addAdresse(lieuStage.getAdresse());
        }
        if(lieuStage.getGeo()!=null){
            addGeo(lieuStage.getGeo());
        }
        lieuRepository.save(lieuStage);
    }


    //ajouter une geolocalisation au repository
    private void addGeo(Geo geo) {
        geoRepository.save(geo);
    }


    // ajouter une organisation au repository
    public void addOrga(Organisation org){
        if(org.getAdresse()!=null){
            addAdresse(org.getAdresse());
        }
        organisationRepository.save(org);
        this.tokenOrg=org.getId();
    }



    // ajouter une addresse au repository
    private void addAdresse(Adresse adresse) {
        adresseRepository.save(adresse);
    }


    // toutes les offres de stage
    @GetMapping()
    public List<OffreStage> getOffresStage() {
      List<OffreStage> listeStage=offreStageRepository.findAll();
        for (OffreStage offre : listeStage) {
            Link link = WebMvcLinkBuilder.linkTo(OffreStageController.class).slash(offre.getId()).withSelfRel();
            offre.add(link);
        }
        return offreStageRepository.findAll();
    }


    /**
     * @id : uuid 
     * retourne l'offre qui a pour id @id
     */
    @GetMapping("/{id}")
    public OffreStage getOffreStage(@PathVariable UUID id) {
        return offreStageRepository.findById(id).orElse(null);
    }



    /**
     * 
     * @param offreStage
     * créer une offre de stage
     * @return l'offre de stage crée
     */
    @PostMapping("/offre")
    public RepresentationModel<?> createOffreStage(@RequestBody OffreStage offreStage) {
        
        offreStage.setOrganisation(organisationRepository.getReferenceById(tokenOrg));
        
        addOffre(offreStage);
        Link link = WebMvcLinkBuilder.linkTo(OffreStageController.class).slash(offreStage.getId()).withSelfRel();
        offreStage.add(link);
       return CollectionModel.of(offreStage);
    }

    
    /**
     * 
     * @param id
     * @param offreStage
     * modifie l'offre de stage qui a pour id @id et la modifie avec l'offre offreStage
     * @return l'offre de stage 
     */
    @PutMapping("/{id}")
    public OffreStage updateOffreStage(@PathVariable UUID id, @RequestBody OffreStage offreStage) {
        //je verifie que l'offre qui a pour id @id existe
        OffreStage existingOffreStage = offreStageRepository.findById(id).orElse(null);
        if (existingOffreStage != null) {
            //je pour chaque élements non nuls passés en parametres je change l'offre
            if(offreStage.getLieuStage()!=null){
                existingOffreStage.setLieuStage(offreStage.getLieuStage());
            }
            if(offreStage.getOrganisation()!=null){
                existingOffreStage.setOrganisation(offreStage.getOrganisation());
            }
            if(offreStage.getNomStage()!=null){
                existingOffreStage.setNomStage(offreStage.getNomStage());
            }
            if(offreStage.getDomaine()!=null){
                existingOffreStage.setDomaine(offreStage.getDomaine());
            }
            if(offreStage.getDescriptionStage()!=null){
                existingOffreStage.setDescriptionStage(offreStage.getDescriptionStage());
            }
            if(offreStage.getNiveauEtudesStage()!=null){
                existingOffreStage.setNiveauEtudesStage(offreStage.getNiveauEtudesStage());
            }
            if(offreStage.getExperienceRequiseStage()!=null){
                existingOffreStage.setExperienceRequiseStage(offreStage.getExperienceRequiseStage());
            }
            if(offreStage.getDateDebutStage()!=null){
                existingOffreStage.setDateDebutStage(offreStage.getDateDebutStage());
            }
            if(Integer.toString(offreStage.getDureeStage())!=null){
                existingOffreStage.setDureeStage(offreStage.getDureeStage());
            }
            if(String.valueOf(offreStage.getSalaireStage())!=null){
                existingOffreStage.setSalaireStage(offreStage.getDureeStage());
            }
           
            return offreStageRepository.save(existingOffreStage);
        } else {
            return null;
        }
    }

    /**
     * 
     * @param id
     * Supprime l'offre qui a pour id @id
     */
    @DeleteMapping("/{id}")
    public void deleteOffreStage(@PathVariable UUID id) {
        offreStageRepository.deleteById(id);
        
    }



    // Créer une adresse
    @PostMapping("/adresse")
    public Adresse createAdresse(@RequestBody Adresse adresse) {
        
        adresseRepository.save(adresse);
        Link link = WebMvcLinkBuilder.linkTo(OffreStageController.class).slash(adresse.getId()).withSelfRel();
        adresse.add(link);
        return adresse;
    }

    //Créer une organisation
    @PostMapping("/orga")
    public RepresentationModel<?> createOrganisation(@RequestBody Organisation orga) {
        System.out.println(orga);
        addOrga(orga);
        Link link = WebMvcLinkBuilder.linkTo(OffreStageController.class).slash(orga.getId()).withSelfRel();
        orga.add(link);
         return CollectionModel.of(orga);
    }

    //j'ajoute un lieu de stage à une offre de stage 
    @PostMapping("/lieu")
        public LieuStage createLieuStage(@RequestBody LieuStage lieu) {
            System.out.println(lieu);
            lieuRepository.save(lieu);
            Link link = WebMvcLinkBuilder.linkTo(OffreStageController.class).slash(lieu.getId()).withSelfRel();
            lieu.add(link);
            return lieu;
    }

    //Retourne la liste des candidats qui ont postulé à une offre
    @GetMapping("/offres/{id}/users")
    public List<Candidature> listeCandidats(@PathVariable UUID id){
        OffreStage of=offreStageRepository.findById(id).orElse(null);
        return of.getCandidat();
    }
   


    // Ajouter un Candidat à une offre qui a l'id 'id'
    @PostMapping("/candidat/{id}")
    public RepresentationModel<?> ajouterCandidat(@PathVariable UUID id,@RequestBody Candidature candidat){
        System.out.println(id);
        System.out.println("candidature = " +candidat);
        OffreStage of= offreStageRepository.findById(id).orElse(null);
        List<Candidature> liste =of.getCandidat();
        liste.add(candidat);
        of.setCandidat(liste);
        // if(of.getNbPlacesPrises()+1<of.ge)
        of.setNbPlacesPrises(of.getNbPlacesPrises()+1);
        offreStageRepository.save(of);
        return CollectionModel.of(of);
    }


}
