package tn.esp.team1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFournisseur implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetailFournisseur;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dateDebutCollaboration;
	private String adresse;
	private String matricule;
	@OneToOne(mappedBy="detailFournisseur")
	@JsonIgnore
	private Fournisseur fournisseur;
	
}