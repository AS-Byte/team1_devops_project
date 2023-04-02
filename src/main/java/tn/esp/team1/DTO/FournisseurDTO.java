package tn.esp.team1.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esp.team1.entities.CategorieFournisseur;
import tn.esp.team1.entities.DetailFournisseur;
import tn.esp.team1.entities.Facture;
import tn.esp.team1.entities.SecteurActivite;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDTO {

    private static final long serialVersionUID = 1L;

    private Long idFournisseur;
    private String code;
    private String libelle;
    private CategorieFournisseur categorieFournisseur;
    private Set<FactureDTO> factures;
    private Set<SecteurActivite> secteurActivites;
    private DetailFournisseur detailFournisseur;

}
