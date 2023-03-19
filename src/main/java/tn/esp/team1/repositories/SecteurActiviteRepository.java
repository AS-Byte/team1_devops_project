package tn.esp.team1.repositories;

import tn.esp.team1.entities.SecteurActivite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SecteurActiviteRepository extends CrudRepository<SecteurActivite, Long> {

}
