package tn.esp.team1.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esp.team1.entities.Facture;
import tn.esp.team1.entities.Produit;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

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
