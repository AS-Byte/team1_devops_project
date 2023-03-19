package tn.esp.team1.services;
import tn.esp.team1.entities.Produit;

import java.util.List;

public interface IProduitService {

    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p);

    void deleteProduit(Long id);

    Produit updateProduit(Produit p);

    Produit retrieveProduit(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);

}
