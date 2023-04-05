package tn.esp.team1.dto;
import java.util.Date;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailFournisseurDTO {
    private static final long serialVersionUID = 1L;

    private Long idDetailFournisseur;
    private String email;

    private Date dateDebutCollaboration;
    private String adresse;
    private String matricule;

    private FournisseurDTO fournisseur;
}
