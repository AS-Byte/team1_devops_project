package tn.esp.team1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esp.team1.entities.Reglement;
import tn.esp.team1.entities.SecteurActivite;
import tn.esp.team1.repositories.ReglementRepository;
import tn.esp.team1.repositories.SecteurActiviteRepository;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
class Team1ApplicationTests {

    @Autowired
    SecteurActiviteRepository secteurActiviteRepo;
    @Autowired
    ReglementRepository reglementRepo;



    SecteurActivite secteur = SecteurActivite.builder().codeSecteurActivite("SEC1").libelleSecteurActivite("Industrie").build();
    Reglement reglement=Reglement.builder().montantPaye(150).montantRestant(200).payee(false).dateReglement(new Date()).build();

    // Classe Secteur Activite
    @Test
    @Order(0)
   public void ajouterSecteurActiviteTest(){
      secteur=secteurActiviteRepo.save(secteur);
      log.info(secteur.toString());
        Assertions.assertNotNull(secteur.getIdSecteurActivite());

    }

    @Test
    @Order(1)
    public void modifierSecteurActiviteTest(){
        secteur.setCodeSecteurActivite("SEC10");
        secteur.setLibelleSecteurActivite("Commerce");
        secteur=secteurActiviteRepo.save(secteur);

        log.info(secteur.toString());
        Assertions.assertNotEquals(secteur.getCodeSecteurActivite(),"SEC1");
        Assertions.assertNotEquals(secteur.getLibelleSecteurActivite(),"Industrie");

    }
    @Test
    @Order(2)
    public void listerSecteursActiviteTest() {
        List<SecteurActivite> lstSecteurs= (List<SecteurActivite>) secteurActiviteRepo.findAll();
        log.info(lstSecteurs.size()+"");
        Assertions.assertTrue(lstSecteurs.size() > 0);

    }


    @Test
    @Order(3)
    public void chercherSecteurByIdTest(){
        log .info(secteur.getIdSecteurActivite()+"");
        SecteurActivite sa=secteurActiviteRepo.findById(secteur.getIdSecteurActivite()).get();
        Assertions.assertEquals(sa.getCodeSecteurActivite(),secteur.getCodeSecteurActivite());
    }

    @Test
    @Order(4)
    public void supprimerSecteurByIdTest() {
   secteurActiviteRepo.delete(secteur);
    }

    // Classe Reglement

    @Test
    @Order(5)
    public  void ajouterReglementTest(){

        reglement=reglementRepo.save(reglement);
        log.info(reglement.toString());
        Assertions.assertNotNull(reglement.getIdReglement());


    }
    @Test
    @Order(6)
    public void retrieveReglementByIdTest(){
        log .info(reglement.getIdReglement()+"");
        Reglement reg=reglementRepo.findById(reglement.getIdReglement()).get();
        Assertions.assertEquals(reg.getMontantPaye(),reglement.getMontantPaye());
        Assertions.assertEquals(reg.getMontantRestant(),reglement.getMontantRestant());
        Assertions.assertEquals(reg.getPayee(),reglement.getPayee());

    }



    @Test
    @Order(7)
    public void listerReglementsTest() {
        List<Reglement> lstReglements= (List<Reglement>) reglementRepo.findAll();
        log.info(lstReglements.size()+"");
        Assertions.assertTrue(lstReglements.size() > 0);

    }


























    @Test
    void contextLoads() {
    }



}
