package tn.esp.team1.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esp.team1.dto.DetailFournisseurDTO;

import tn.esp.team1.dto.FournisseurDTO;
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
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        for (Fournisseur fournisseur : fournisseurs) {
            log.info(" fournisseur : " + fournisseur);
        }
        return fournisseurs;
    }


    public FournisseurDTO addFournisseur(FournisseurDTO f /*Master*/) {

        Fournisseur fournisseurEntity = modelMapper.map(f, Fournisseur.class);
        DetailFournisseur df = new DetailFournisseur();//Slave
        df.setDateDebutCollaboration(new Date()); //util
        //On affecte le "Slave" au "Master"
        fournisseurEntity.setDetailFournisseur(df);
        Fournisseur fournisseur = fournisseurRepository.save(fournisseurEntity);
        return modelMapper.map(fournisseur, FournisseurDTO.class);

    }

    private DetailFournisseurDTO  saveDetailFournisseur(FournisseurDTO f){
        DetailFournisseurDTO df = f.getDetailFournisseur();
        DetailFournisseur detailFournisseurEntity = modelMapper.map(df, DetailFournisseur.class);
        DetailFournisseur detailFournisseur = detailFournisseurRepository.save(detailFournisseurEntity);
        return modelMapper.map(detailFournisseur, DetailFournisseurDTO.class);
    }

    public FournisseurDTO updateFournisseur(FournisseurDTO f) {
        DetailFournisseurDTO df = saveDetailFournisseur(f);
        f.setDetailFournisseur(df);
        Fournisseur fournisseurEntity = modelMapper.map(f, Fournisseur.class);
        Fournisseur fournisseur = fournisseurRepository.save(fournisseurEntity);
        return modelMapper.map(fournisseur, FournisseurDTO.class);
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