package tn.esp.team1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tn.esp.team1.entities.Stock;

import java.util.Date;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO {

    private static final long serialVersionUID = 1L;
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prix;
    private Date dateCreation;
    private Date dateDerniereModification;
    private Stock stock;
    private Set<DetailFactureDTO> detailFacture;
    private CategorieProduitDTO categorieProduit;
}