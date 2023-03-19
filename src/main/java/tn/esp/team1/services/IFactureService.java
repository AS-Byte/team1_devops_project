package tn.esp.team1.services;

import tn.esp.team1.entities.Facture;

import java.util.Date;
import java.util.List;

public interface IFactureService {
    List<Facture> retrieveAllFactures();

    List<Facture> getFacturesByFournisseur(Long idFournisseur);

    Facture addFacture(Facture f);

    void cancelFacture(Long id);

    Facture retrieveFacture(Long id);

    void assignOperateurToFacture(Long idOperateur, Long idFacture);

    float pourcentageRecouvrement(Date startDate, Date endDate);

}

