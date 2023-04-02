package tn.esp.team1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esp.team1.entities.Facture;
import tn.esp.team1.entities.Fournisseur;
import tn.esp.team1.repositories.FactureRepository;
import tn.esp.team1.repositories.FournisseurRepository;
import tn.esp.team1.services.FactureServiceImpl;
import tn.esp.team1.services.FournisseurServiceImpl;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {

    @Mock
    private FactureRepository factureRepository;
    @Mock
    FournisseurRepository fournisseurRepository;

    @InjectMocks
    private FactureServiceImpl factureService;
    @InjectMocks
    FournisseurServiceImpl fournisseurService;

    @Test
    void retreiveFactureTest(){
        Facture facture = Facture.builder().montantFacture(100).build();
        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        Facture f = factureService.retrieveFacture(2L);
        assertNotNull(f);
        Assertions.assertEquals(f, facture);
    }

    @Test
    void retrieveFournisseurTest(){
        Fournisseur fournisseur = Fournisseur.builder().libelle("fournisseur1").build();
        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur f = fournisseurService.retrieveFournisseur(2L);
        assertNotNull(f);
        Assertions.assertEquals(f, fournisseur);
    }
}
