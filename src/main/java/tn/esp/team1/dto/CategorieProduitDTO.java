package tn.esp.team1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esp.team1.entities.Produit;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorieProduitDTO {

    private static final long serialVersionUID = 1L;
    private Long idCategorieProduit;
    private String codeCategorie;
    private String libelleCategorie;
    private Set<ProduitDTO> produits;
}
