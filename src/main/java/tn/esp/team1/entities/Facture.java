package tn.esp.team1.entities;

import java.io.Serializable;
import java.time.LocalDate;
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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private float montantRemise;
    private float montantFacture;

    private LocalDate dateCreationFacture;

    private LocalDate dateDerniereModificationFacture;
    private Boolean archivee;
    @OneToMany(mappedBy = "facture")
    private Set<DetailFacture> detailsFacture;
    @ManyToOne
    @JsonIgnore
    private Fournisseur fournisseur;
    @OneToMany(mappedBy="facture")
    @JsonIgnore
    private Set<Reglement> reglements;


}
