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

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@EnableAutoConfiguration
@ContextConfiguration(classes = {FournisseurRepository.class}) //h2 embarqué
public class FournisseurRepositoryTest {

    @Autowired
    FournisseurRepository fournisseurRepository;


    @Test
    @Order(0)
    public void addFournisseurTest(){
        Fournisseur fournisseur = Fournisseur.builder().code("code1").build();
        fournisseur =fournisseurRepository.save(fournisseur);
        log.info("msg"+fournisseur.toString());
        Assertions.assertNotNull(fournisseur.getIdFournisseur());
    }

    @Test
    @Order(1)
    public void getAllFournisseursTest() {
        List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
        log.info("Taille de la liste = "+fournisseurs.size());
        Assertions.assertTrue(fournisseurs.size() > 0);

    }

    @Test
    @Order(2)
    public void getFournisseurById(){
        Fournisseur fournisseur = Fournisseur.builder().code("code1").build();
        fournisseur =fournisseurRepository.save(fournisseur);
        log .info("id fournisseur = "+fournisseur.getIdFournisseur());
        Fournisseur fournisseur2 =fournisseurRepository.findById(fournisseur.getIdFournisseur()).get();
        Assertions.assertEquals(fournisseur2.getCode(),fournisseur.getCode());
    }

    @Test
    @Order(3)
    public void modifyFournisseurTest(){
        Fournisseur fournisseur = Fournisseur.builder().code("code1").build();
        fournisseur=fournisseurRepository.save(fournisseur);
        fournisseur.setCode("code2");
        fournisseur=fournisseurRepository.save(fournisseur);
        log.info(fournisseur.toString());
        Assertions.assertNotEquals(fournisseur.getCode(),"code1");
    }

    @Test
    @Order(4)
    public void deleteFournisseurByIdTest() {
        Fournisseur fournisseur = Fournisseur.builder().code("code1").build();
        fournisseur=fournisseurRepository.save(fournisseur);
        Assertions.assertNotEquals( Optional.empty(),fournisseurRepository.findById(fournisseur.getIdFournisseur()));
        fournisseurRepository.delete(fournisseur);
        Assertions.assertEquals( Optional.empty(),fournisseurRepository.findById(fournisseur.getIdFournisseur()));
    }


}
