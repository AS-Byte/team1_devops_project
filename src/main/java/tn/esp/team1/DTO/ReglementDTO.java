package tn.esp.team1.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esp.team1.entities.Facture;

import javax.persistence.*;
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
    private Facture facture;

}
