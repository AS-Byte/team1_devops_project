package tn.esp.team1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esp.team1.entities.Facture;
import tn.esp.team1.entities.Fournisseur;
import tn.esp.team1.repositories.FactureRepository;
import tn.esp.team1.repositories.FournisseurRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@EnableAutoConfiguration
@ContextConfiguration(classes = {FactureRepository.class}) //h2 embarqué
public class FactureRepositoryTest {

    @Autowired
    FactureRepository factureRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;


    @Test
    @Order(0)
    public void addFactureTest(){
        Facture facture = Facture.builder().montantFacture(100).build();
        facture =factureRepository.save(facture);
        log.info("msg"+facture.toString());
        Assertions.assertNotNull(facture.getIdFacture());
    }

    @Test
    @Order(1)
    public void getAllFacturesTest() {
        List<Facture> factures = (List<Facture>) factureRepository.findAll();
        log.info("Taille de la liste = "+factures.size());
        Assertions.assertTrue(factures.size() > 0);

    }

    @Test
    @Order(2)
    public void getFactureById(){
        Facture facture = Facture.builder().montantFacture(100).build();
        facture =factureRepository.save(facture);
        log .info("id facture = "+facture.getIdFacture());
        Facture facture2 =factureRepository.findById(facture.getIdFacture()).get();
        Assertions.assertEquals(facture2.getMontantFacture(),facture.getMontantFacture());
    }

    @Test
    @Order(3)
    public void modifyFactureTest(){
        Facture facture = Facture.builder().montantFacture(100).build();
        facture=factureRepository.save(facture);
        facture.setMontantFacture(500);
        facture=factureRepository.save(facture);
        log.info(facture.toString());
        Assertions.assertNotEquals(facture.getMontantFacture(),100);
    }

    @Test
    @Order(4)
    public void deleteFactureByIdTest() {
        Facture facture = Facture.builder().montantFacture(100).build();
        facture=factureRepository.save(facture);
        Assertions.assertNotEquals( Optional.empty(),factureRepository.findById(facture.getIdFacture()));
        factureRepository.delete(facture);
        Assertions.assertEquals( Optional.empty(),factureRepository.findById(facture.getIdFacture()));
    }

    @Test
    @Order(5)
    public void getTotalFacturesEntreDeuxDates(){
        LocalDate date1 = LocalDate.of( 2014 , 2 , 11 );
        LocalDate date2 = LocalDate.of( 2015 , 2 , 11 );
        Facture facture1 = Facture.builder().dateCreationFacture(date1).montantFacture(100).archivee(false).build();
        facture1=factureRepository.save(facture1);
        Facture facture2 = Facture.builder().dateCreationFacture(date2).montantFacture(200).archivee(false).build();
        facture2=factureRepository.save(facture2);
        Assertions.assertEquals(300, factureRepository.getTotalFacturesEntreDeuxDates(date1,date2));

    }

        @Test
        @Order(6)
        public void getFactureByFournisseur(){
            Facture facture = Facture.builder().montantFacture(100).archivee(false).build();
            Fournisseur fournisseur = Fournisseur.builder().code("fournisseur1").build();
            fournisseur = fournisseurRepository.save(fournisseur);
            facture.setFournisseur(fournisseur);
            facture = factureRepository.save(facture);
            Assertions.assertEquals(facture.getIdFacture(), factureRepository.getFactureByFournisseur(fournisseur).get(0).getIdFacture());
        }


}
