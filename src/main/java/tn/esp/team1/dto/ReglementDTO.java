package tn.esp.team1.dto;

import lombok.*;


import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReglementDTO {

    private static final long serialVersionUID = 1L;

    private Long idReglement;
    private float montantPaye;
    private float montantRestant;
    private Boolean payee;
    private Date dateReglement;
    private FactureDTO facture;

}
