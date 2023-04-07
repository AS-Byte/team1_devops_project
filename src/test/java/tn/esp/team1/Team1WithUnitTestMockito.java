package tn.esp.team1;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esp.team1.entities.Reglement;
import tn.esp.team1.entities.SecteurActivite;
import tn.esp.team1.repositories.ReglementRepository;
import tn.esp.team1.repositories.SecteurActiviteRepository;
import tn.esp.team1.services.ReglementServiceImpl;
import tn.esp.team1.services.SecteurActiviteServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Team1WithUnitTestMockito {

    @Mock
    ReglementRepository reglementRepo;
    @Mock
    SecteurActiviteRepository secteurRepo;

    @InjectMocks
    ReglementServiceImpl reglementService;
    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteService;


    SecteurActivite secteur = SecteurActivite.builder().codeSecteurActivite("SEC1").libelleSecteurActivite("Industrie").build();
    Reglement reglement=Reglement.builder().montantPaye(150).montantRestant(200).payee(false).dateReglement(new Date()).build();

    List<SecteurActivite> lstSecteurs=new ArrayList<SecteurActivite>(){

        {
            add(secteur.builder().codeSecteurActivite("SEC1").libelleSecteurActivite("Industrie").build());
            add(secteur.builder().codeSecteurActivite("SEC2").libelleSecteurActivite("Sante").build());
            add(secteur.builder().codeSecteurActivite("SEC3").libelleSecteurActivite("Education").build());

        }
    };
    List<Reglement> lstReglements=new ArrayList<Reglement>(){

        {
            add(reglement.builder().montantPaye(150).montantRestant(200).payee(false).dateReglement(new Date()).build());
            add(reglement.builder().montantPaye(400).montantRestant(300).payee(false).dateReglement(new Date()).build());
            add(reglement.builder().montantPaye(560).montantRestant(750).payee(false).dateReglement(new Date()).build());

        }

    };

 // Classe Secteur Activite
   @Test
    public void retrieveSecteurActiviteTest(){
       Mockito.when(secteurRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(secteur));
       SecteurActivite secteurActivity=secteurActiviteService.retrieveSecteurActivite((long) 2);
       assertNotNull(secteurActivity);
       log.info("get ==> " + secteurActivity.toString());
       verify(secteurRepo).findById(Mockito.anyLong());
   }

    @Test
    public void retreiveAllSecteursTest(){
    Mockito.when(secteurRepo.findAll()).thenReturn(lstSecteurs);
    List<SecteurActivite> secteurslist = secteurActiviteService.retrieveAllSecteurActivite();
    assertNotNull(secteurslist);
    for(SecteurActivite secteur:secteurslist){
        log.info(secteur.toString());
    }

    }

    @Test
    public void addSecteurTest(){

        Mockito.when(secteurRepo.save(Mockito.any(SecteurActivite.class))).then(invocation ->{
            SecteurActivite secteurModel=invocation.getArgument(0,SecteurActivite.class);
            secteurModel.setIdSecteurActivite(Long.valueOf(1));
            return secteurModel;
        });

        log.info("Avant ==> " + secteur.toString());
        SecteurActivite secteurActivity = secteurActiviteService.addSecteurActivite(secteur);
        assertSame(secteurActivity,secteur);
        log.info("Après ==> "+ secteur.toString());

    }
   // Classe Reglement
   @Test
   public void retrieveReglementTest(){
       Mockito.when(reglementRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
       Reglement payement=reglementService.retrieveReglement(((long) 1));
       assertNotNull(payement);
       log.info("get ==> " + payement.toString());
       verify(reglementRepo).findById(Mockito.anyLong());
   }
    @Test
    public void retreiveAllReglementsTest(){
        Mockito.when(reglementRepo.findAll()).thenReturn(lstReglements);
        List<Reglement> payementslist = reglementService.retrieveAllReglements();
        assertNotNull(payementslist);
        for(Reglement reglement1:payementslist){
            log.info(reglement1.toString());
        }

    }


    @Test
    public void addReglementTest(){

        Mockito.when(reglementRepo.save(Mockito.any(Reglement.class))).then(invocation ->{
            Reglement reglementModel=invocation.getArgument(0,Reglement.class);
            reglementModel.setIdReglement(Long.valueOf(1));
            return reglementModel;
        });

        log.info("Avant ==> " + reglement.toString());
        Reglement reglement1 = reglementService.addReglement(reglement);
        assertSame(reglement1,reglement);
        log.info("Après ==> "+ reglement.toString());

    }





















}
