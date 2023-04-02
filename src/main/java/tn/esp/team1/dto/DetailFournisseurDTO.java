package tn.esp.team1.dto;
import java.util.Date;


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
