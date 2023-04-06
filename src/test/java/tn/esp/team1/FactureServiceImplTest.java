package tn.esp.team1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esp.team1.dto.DetailFournisseurDTO;
import tn.esp.team1.dto.FactureDTO;
import tn.esp.team1.dto.FournisseurDTO;
import tn.esp.team1.entities.DetailFournisseur;
import tn.esp.team1.entities.Facture;
import tn.esp.team1.entities.Fournisseur;
import tn.esp.team1.repositories.DetailFournisseurRepository;
import tn.esp.team1.repositories.FactureRepository;
import tn.esp.team1.repositories.FournisseurRepository;
import tn.esp.team1.services.FactureServiceImpl;
import tn.esp.team1.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {

    @Mock
    private FactureRepository factureRepository;

    @InjectMocks
    private FactureServiceImpl factureService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void retreiveFactureTest(){
        Facture facture = Facture.builder().montantFacture(100).build();
        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        Facture f = factureService.retrieveFacture(2L);
        assertNotNull(f);
        Assertions.assertEquals(f, facture);
    }

    @Test
    void retrieveAllFacturesTest(){
        Facture facture = Facture.builder().montantFacture(100).build();
        List list = new ArrayList<>();
        list.add(facture);
        Mockito.when(factureRepository.findAll()).thenReturn(list);
        List factures =factureService.retrieveAllFactures();
        Assertions.assertEquals(list, factures);

    }

    @Test
    void addFactureTest(){
        Facture facture = Facture.builder().montantFacture(100).build();
        Mockito.when(factureRepository.save(Mockito.any())).thenReturn(facture);

        FactureDTO factureDTO = FactureDTO.builder().idFacture(1L).build();
        Mockito.when(modelMapper.map(factureDTO, Facture.class)).thenReturn(facture);
        Mockito.when(modelMapper.map(facture, FactureDTO.class)).thenReturn(factureDTO);

        FactureDTO result = factureService.addFacture(factureDTO);
        Assertions.assertEquals( 1L,result.getIdFacture());

    }



}
