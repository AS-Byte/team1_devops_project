package tn.esp.team1.dto;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFournisseurDTO {
    private static final long serialVersionUID = 1L;

    private Long idDetailFournisseur;
    private String email;

    private Date dateDebutCollaboration;
    private String adresse;
    private String matricule;

    private FournisseurDTO fournisseur;
}
