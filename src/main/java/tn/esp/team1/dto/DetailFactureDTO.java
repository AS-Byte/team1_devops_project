package tn.esp.team1.dto;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailFactureDTO {

    private static final long serialVersionUID = 1L;

    private Long idDetailFacture;
    private Integer qteCommandee;
    private float prixTotalDetail;
    private Integer pourcentageRemise;
    private float montantRemise;
    private ProduitDTO produit;
    private FactureDTO facture;
}
