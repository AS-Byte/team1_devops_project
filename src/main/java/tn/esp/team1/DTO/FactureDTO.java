package tn.esp.team1.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esp.team1.entities.DetailFacture;
import tn.esp.team1.entities.Fournisseur;
import tn.esp.team1.entities.Reglement;

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

