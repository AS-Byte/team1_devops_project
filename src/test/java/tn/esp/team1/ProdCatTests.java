package tn.esp.team1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esp.team1.entities.CategorieProduit;
import tn.esp.team1.entities.Produit;
import tn.esp.team1.repositories.CategorieProduitRepository;
import tn.esp.team1.repositories.ProduitRepository;
import tn.esp.team1.services.ProduitServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@EnableAutoConfiguration
@ContextConfiguration(classes = {ProduitRepository.class, CategorieProduitRepository.class})
public class ProdCatTests {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitService;

    Produit p = Produit.builder().codeProduit("1").build();
    List<Produit> list=new ArrayList<Produit>() {
        {
            add(Produit.builder().codeProduit("2").build());
            add(Produit.builder().codeProduit("3").build());
        }

    };

    @Test
    public void addProduitTest() {
        Mockito.when(produitRepository.save(Mockito.any(Produit.class))).then(invocation -> {
            Produit model = invocation.getArgument(0, Produit.class);
            model.setIdProduit(1L);
            return model;
        });
        log.info("Avant ==> " + p.toString());
        Produit produit = produitService.addProduit(p);
        assertSame(produit, p);
        log.info("Après ==> " + p.toString());
    }

    @Test
    public void updateProduitTest() {
        Mockito.when(produitRepository.save(Mockito.any(Produit.class))).then(invocation -> {
            Produit model = invocation.getArgument(0, Produit.class);
            model.setIdProduit(1L);
            return model;
        });
        log.info("Avant ==> " + p.toString());
        Produit produit = produitService.updateProduit(p);
        assertSame(produit, p);
        log.info("Après ==> " + p.toString());
    }

    @Test
    public void retreiveProduitTest() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Produit produit = produitService.retrieveProduit((long) 2);
        assertNotNull(produit);
        log.info("get ==> " + produit.toString());

        verify(produitRepository).findById(Mockito.anyLong());

    }

    @Test
    public void retreiveAllProduitTest() {
        Mockito.when(produitRepository.findAll()).thenReturn(list);
        List<Produit> magasins = produitRepository.findAll();
        assertNotNull(magasins);
        for (Produit magasin : magasins) {
            log.info(magasin.toString());
        }
    }
}