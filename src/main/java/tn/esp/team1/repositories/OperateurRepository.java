package tn.esp.team1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esp.team1.entities.Operateur;


@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {

}