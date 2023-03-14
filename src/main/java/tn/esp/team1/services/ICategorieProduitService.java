package tn.esp.team1.services;

import tn.esp.team1.entities.CategorieProduit;

import java.util.List;
public interface ICategorieProduitService {

    List<CategorieProduit> retrieveAllCategorieProduits();

    CategorieProduit addCategorieProduit(CategorieProduit cp);

    void deleteCategorieProduit(Long id);

    CategorieProduit updateCategorieProduit(CategorieProduit cp);

    CategorieProduit retrieveCategorieProduit(Long id);

}