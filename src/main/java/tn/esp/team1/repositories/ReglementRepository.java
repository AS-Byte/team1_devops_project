package tn.esp.team1.repositories;

import tn.esp.team1.entities.Reglement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReglementRepository extends CrudRepository<Reglement, Long>{
	@Query("SELECT r FROM Reglement r where r.facture.idFacture=:idFacture")
	List<Reglement> retrieveReglementByFacture(@Param("idFacture") Long idFacture);

	
	@Query("SELECT sum(r.montantPaye) FROM Reglement r where  r.dateReglement between :startDate"
			+ " and :endDate and r.facture.archivee=false")
	float getChiffreAffaireEntreDeuxDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
