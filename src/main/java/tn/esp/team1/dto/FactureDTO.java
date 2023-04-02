package tn.esp.team1.dto;

import java.util.Date;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FactureDTO {


    private static final long serialVersionUID = 1L;

    private Long idFacture;
    private float montantRemise;
    private float montantFacture;
    private Date dateCreationFacture;
    private Date dateDerniereModificationFacture;
    private Boolean archivee;
    private Set<DetailFactureDTO> detailsFacture;
    private FournisseurDTO fournisseur;
    private Set<ReglementDTO> reglements;



}

