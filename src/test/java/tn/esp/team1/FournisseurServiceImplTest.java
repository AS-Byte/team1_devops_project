package tn.esp.team1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import tn.esp.team1.dto.DetailFournisseurDTO;
import tn.esp.team1.dto.FournisseurDTO;
import tn.esp.team1.entities.DetailFournisseur;
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
public class FournisseurServiceImplTest {


    @Mock
    FournisseurRepository fournisseurRepository;

    @Mock
    DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    FournisseurServiceImpl fournisseurService;

    @Test
    void retrieveFournisseurTest(){
        Fournisseur fournisseur = Fournisseur.builder().libelle("fournisseur1").build();
        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur f = fournisseurService.retrieveFournisseur(2L);
        assertNotNull(f);
        Assertions.assertEquals(f, fournisseur);
    }

    @Test
    void retrieveAllFournisseursTest(){
        Fournisseur fournisseur = Fournisseur.builder().libelle("fournisseur1").build();
        List list = new ArrayList<>();
        list.add(fournisseur);
        Mockito.when(fournisseurRepository.findAll()).thenReturn(list);
        List fournisseurs =fournisseurService.retrieveAllFournisseurs();
        Assertions.assertEquals(list, fournisseurs);

    }

    @Test
    void addFournisseurTest(){
        Fournisseur fournisseur = Fournisseur.builder().libelle("fournisseur1").build();
        Mockito.when(fournisseurRepository.save(Mockito.any())).thenReturn(fournisseur);

        FournisseurDTO fournisseurDTO = FournisseurDTO.builder().idFournisseur(1L).build();
        Mockito.when(modelMapper.map(fournisseurDTO, Fournisseur.class)).thenReturn(fournisseur);
        Mockito.when(modelMapper.map(fournisseur, FournisseurDTO.class)).thenReturn(fournisseurDTO);

        FournisseurDTO result = fournisseurService.addFournisseur(fournisseurDTO);
        Assertions.assertEquals( 1L,result.getIdFournisseur());

    }

    @Test
    void updateFournisseurTest(){

        Fournisseur fournisseur = Fournisseur.builder().libelle("fournisseur1").build();
        fournisseur.setDetailFournisseur(DetailFournisseur.builder().idDetailFournisseur(200L).build());
        Mockito.when(fournisseurRepository.save(Mockito.any())).thenReturn(fournisseur);

        FournisseurDTO fournisseurDTO = FournisseurDTO.builder().idFournisseur(1L).build();
        fournisseurDTO.setDetailFournisseur(DetailFournisseurDTO.builder().idDetailFournisseur(200L).build());

        Mockito.when(modelMapper.map(fournisseurDTO, Fournisseur.class)).thenReturn(fournisseur);
        Mockito.when(modelMapper.map(fournisseur, FournisseurDTO.class)).thenReturn(fournisseurDTO);

        DetailFournisseurDTO df = fournisseurDTO.getDetailFournisseur();
        DetailFournisseur dfEntity = fournisseur.getDetailFournisseur();
        Mockito.when(modelMapper.map(dfEntity, DetailFournisseurDTO.class)).thenReturn(df);
        Mockito.when(modelMapper.map(df, DetailFournisseur.class)).thenReturn(dfEntity);
        Mockito.when(detailFournisseurRepository.save(Mockito.any())).thenReturn(dfEntity);

        FournisseurDTO result = fournisseurService.updateFournisseur(fournisseurDTO);
        Assertions.assertEquals( 1L,result.getIdFournisseur());
    }
}
