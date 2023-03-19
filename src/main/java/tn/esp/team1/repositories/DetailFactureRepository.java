package tn.esp.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esp.team1.entities.DetailFacture;


@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {

}
