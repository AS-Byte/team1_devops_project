package tn.esp.team1.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esp.team1.entities.DetailFournisseur;
import tn.esp.team1.entities.Fournisseur;
import tn.esp.team1.entities.SecteurActivite;
import tn.esp.team1.repositories.DetailFournisseurRepository;
import tn.esp.team1.repositories.FournisseurRepository;
import tn.esp.team1.repositories.ProduitRepository;
import tn.esp.team1.repositories.SecteurActiviteRepository;

@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {

    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    DetailFournisseurRepository detailFournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    SecteurActiviteRepository secteurActiviteRepository;

    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        for (Fournisseur fournisseur : fournisseurs) {
            log.info(" fournisseur : " + fournisseur);
        }
        return fournisseurs;
    }


    public Fournisseur addFournisseur(Fournisseur f /*Master*/) {
        DetailFournisseur df= new DetailFournisseur();//Slave
        df.setDateDebutCollaboration(new Date()); //util
        //On affecte le "Slave" au "Master"
        f.setDetailFournisseur(df);
        fournisseurRepository.save(f);
        return f;
    }

    private DetailFournisseur  saveDetailFournisseur(Fournisseur f){
        DetailFournisseur df = f.getDetailFournisseur();
        detailFournisseurRepository.save(df);
        return df;
    }

    public Fournisseur updateFournisseur(Fournisseur f) {
        DetailFournisseur df = saveDetailFournisseur(f);
        f.setDetailFournisseur(df);
        fournisseurRepository.save(f);
        return f;
    }

    @Override
    public void deleteFournisseur(Long fournisseurId) {
        fournisseurRepository.deleteById(fournisseurId);

    }

    @Override
    public Fournisseur retrieveFournisseur(Long fournisseurId) {

        return fournisseurRepository.findById(fournisseurId).orElse(null);

    }

    @Override
    public void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur) {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(idFournisseur);
        SecteurActivite secteurActivite = secteurActiviteRepository.findById(idSecteurActivite).orElse(null);
        if(fournisseur.isPresent()) {
            fournisseur.get().getSecteurActivites().add(secteurActivite);
            fournisseurRepository.save(fournisseur.get());
        }
    }



}