package org.miage.stageAPI.Controller;

import java.util.Collection;
import java.util.List;

import java.util.UUID;




import org.miage.stageAPI.Entity.Candidature;

import org.miage.stageAPI.Entity.OffreStage;

import org.miage.stageAPI.Repository.CandidatureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping("")
public class CandidatController {

    @Autowired
    private CandidatureRepository candidatures;

    String url= "http://127.0.0.1:8090/api/offres-stage";

/*    @Autowired
   private CandidatureRepository candidatures; */
 
   @Autowired
   private RestTemplate restTemplate;
   private UUID token=null;

   //retourne la liste de stages
   @RequestMapping("/listeStage")
   public OffreStage[] getProductList() {
      OffreStage[] offres = restTemplate.getForObject(url, OffreStage[].class);
      return offres;
   } 

   //retourne informations sur le candidat
    @GetMapping("/{id}")
    public Candidature getCandidat(@PathVariable UUID id) {
         return candidatures.findById(id).orElse(null);
    }
 
 
    //retourne les offres auxquelles le candidat a postulé
    @GetMapping("/{id}/offre")
    public List<UUID> getOffresCandidature(@PathVariable UUID id) {
        return candidatures.findIdsOffreStageByIdCandidature(id);
    } 


    //ajouter un candidat à une offre
    @PostMapping("/offre/{id}")
    public  ResponseEntity<?> postuler(@PathVariable UUID id,@RequestBody Candidature candidat){
       String uri= url+"/candidat/" + id; 
       ResponseEntity<OffreStage> response = restTemplate.postForEntity(uri, candidat, OffreStage.class);
      return ResponseEntity.status(response.getStatusCode()).build();
    } 

    //ajouter un candidat
    @PostMapping("/candidat")
    public RepresentationModel<?> créerCandidature(@RequestBody Candidature candidat){
      candidatures.save(candidat);
      this.token=candidat.getId();
      Link link = WebMvcLinkBuilder.linkTo(Candidature.class).slash(candidat.getId()).withSelfRel();
      candidat.add(link);
      return CollectionModel.of(candidat);
      
    } 

}
