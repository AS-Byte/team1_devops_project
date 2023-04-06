package tn.esp.team1.dto;

import java.time.LocalDate;
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
    private LocalDate dateCreationFacture;
    private LocalDate dateDerniereModificationFacture;
    private Boolean archivee;
    private Set<DetailFactureDTO> detailsFacture;
    private FournisseurDTO fournisseur;
    private Set<ReglementDTO> reglements;



}

