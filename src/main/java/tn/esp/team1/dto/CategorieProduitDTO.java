package tn.esp.team1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
