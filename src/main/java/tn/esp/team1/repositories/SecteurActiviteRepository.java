package tn.esp.team1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esp.team1.entities.SecteurActivite;


@Repository
public interface SecteurActiviteRepository extends CrudRepository<SecteurActivite, Long> {

}