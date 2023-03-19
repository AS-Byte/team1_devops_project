package tn.esp.team1.services;

import tn.esp.team1.entities.Fournisseur;

import java.util.List;


public interface IFournisseurService {

    List<Fournisseur> retrieveAllFournisseurs();

    Fournisseur addFournisseur(Fournisseur f);

    void deleteFournisseur(Long id);

    Fournisseur updateFournisseur(Fournisseur f);

    Fournisseur retrieveFournisseur(Long id);

    void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}
