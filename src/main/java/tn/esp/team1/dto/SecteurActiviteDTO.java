package tn.esp.team1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esp.team1.entities.Fournisseur;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecteurActiviteDTO {

    private static final long serialVersionUID = 1L;

    private Long idSecteurActivite;
    private String codeSecteurActivite;
    private String libelleSecteurActivite;

    private Set<FournisseurDTO> fournisseurs;
}
