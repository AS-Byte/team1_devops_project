package tn.esp.team1.services;

import tn.esp.team1.dto.FournisseurDTO;
import tn.esp.team1.entities.Fournisseur;

import java.util.List;


public interface IFournisseurService {

    List<Fournisseur> retrieveAllFournisseurs();

    FournisseurDTO addFournisseur(FournisseurDTO f);

    void deleteFournisseur(Long id);

    FournisseurDTO updateFournisseur(FournisseurDTO f);

    Fournisseur retrieveFournisseur(Long id);

    void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}
