package tn.esp.team1.dto;

import lombok.*;

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
