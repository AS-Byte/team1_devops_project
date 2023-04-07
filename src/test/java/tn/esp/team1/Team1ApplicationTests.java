package tn.esp.team1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esp.team1.entities.CategorieProduit;
import tn.esp.team1.entities.Produit;
import tn.esp.team1.entities.Reglement;
import tn.esp.team1.entities.SecteurActivite;
import tn.esp.team1.repositories.CategorieProduitRepository;
import tn.esp.team1.repositories.ProduitRepository;
import tn.esp.team1.repositories.ReglementRepository;
import tn.esp.team1.repositories.SecteurActiviteRepository;
import java.util.Date;
import java.util.List;
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
@EnableAutoConfiguration
@ContextConfiguration(classes = {ProduitRepository.class, CategorieProduitRepository.class})
class Team1ApplicationTests {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    CategorieProduitRepository categorieProduitRepository;

    Produit produit = Produit.builder().codeProduit("P1").libelleProduit("lait").prix(Float.parseFloat("1,800")).dateCreation(new Date()).dateDerniereModification(new Date()).build();
    CategorieProduit categorieProduit=CategorieProduit.builder().codeCategorie("perissable").libelleCategorie("pretamanger").build();

    // Test de Classe Produit
    @Test
    @Order(0)
    void ajouterProduitTest(){
        produit=produitRepository.save(produit);
        log.info(produit.toString());
        Assertions.assertNotNull(produit.getIdProduit());
    }

    @Test
    @Order(1)
    void modifierProduitTest(){
        produit.setCodeProduit("Px");
        produit.setLibelleProduit("farine");
        produit.setPrix(Float.parseFloat("1,5"));
        produit=produitRepository.save(produit);

        log.info(produit.toString());
        Assertions.assertNotEquals("P1", produit.getCodeProduit());
        Assertions.assertNotEquals("lait" ,produit.getLibelleProduit());
        Assertions.assertNotEquals(1.800, produit.getPrix());
    }
    @Test
    @Order(2)
    void listerProduitTest() {
        List<Produit> lstProduits= (List<Produit>) produitRepository.findAll();
        log.info(lstProduits.size()+"");
        Assertions.assertTrue(lstProduits.size() > 0);

    }
    @Test
    @Order(3)
    void chercherProduitByIdTest(){
        log .info(produit.getIdProduit()+"");
        Produit pdt=produitRepository.findById(produit.getIdProduit()).get();
        Assertions.assertEquals(pdt.getCodeProduit(),produit.getCodeProduit());
    }
    @Test
    @Order(4)
    void supprimerProduit() {
        produitRepository.delete(produit);
        Assertions.assertNull(produit);
    }
    // Test de Classe Categorie produit
    @Test
    @Order(5)
    void ajouterCategorieProduitTest(){

        categorieProduit=categorieProduitRepository.save(categorieProduit);
        log.info(categorieProduit.toString());
        Assertions.assertNotNull(categorieProduit.getIdCategorieProduit());
    }
    @Test
    @Order(6)
    void retrieveCategorieProduitByIdTest(){
        log .info(categorieProduit.getIdCategorieProduit()+"");
        CategorieProduit cat= categorieProduitRepository.findById(categorieProduit.getIdCategorieProduit()).get();
        Assertions.assertEquals(cat.getCodeCategorie(),categorieProduit.getCodeCategorie());
        Assertions.assertEquals(cat.getLibelleCategorie(),categorieProduit.getLibelleCategorie());

    }

    @Test
    @Order(7)
    void listerRCategoriesProduitTest() {
        List<CategorieProduit> lstCats= (List<CategorieProduit>) categorieProduitRepository.findAll();
        log.info(lstCats.size()+"");
        Assertions.assertTrue(lstCats.size() > 0);

    }
}