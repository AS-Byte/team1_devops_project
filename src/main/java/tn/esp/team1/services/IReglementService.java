package tn.esp.team1.services;

import tn.esp.team1.entities.Reglement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReglementService {

	List<Reglement> retrieveAllReglements();
	Reglement addReglement(Reglement r);
	Reglement retrieveReglement(Long id);
	List<Reglement> retrieveReglementByFacture(Long idFacture);
	float getChiffreAffaireEntreDeuxDate(LocalDate startDate, LocalDate endDate);

}
