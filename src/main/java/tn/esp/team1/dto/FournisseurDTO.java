package tn.esp.team1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esp.team1.entities.CategorieFournisseur;

import tn.esp.team1.entities.SecteurActivite;

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
    private DetailFournisseurDTO detailFournisseur;

}
