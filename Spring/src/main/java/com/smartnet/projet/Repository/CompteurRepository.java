package com.smartnet.projet.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.smartnet.projet.Model.Compteur;




@Repository
public interface CompteurRepository extends JpaRepository <Compteur, Long> {

	Optional<Compteur> findByAnnee(int annee);
	@Query(value = "SELECT count(*) FROM Compteur  where annee  = :annee")
	public int nbre(@Param("annee") int annee);



}
