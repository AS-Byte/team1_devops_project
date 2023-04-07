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
@SpringBootTest(classes = Team1ApplicationTests.class)
class Team1ApplicationTests {
    @Test
    void contextLoads() {
    }

}