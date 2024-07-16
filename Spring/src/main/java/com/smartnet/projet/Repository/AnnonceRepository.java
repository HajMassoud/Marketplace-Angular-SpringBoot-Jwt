package com.smartnet.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartnet.projet.Model.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository <Annonce, Long> {

	@Query(value="SELECT new com.smartnet.projet.Model.Annonce(a.id,a.clientname,a.libelle,a.adresse,a.tel1,a.tel2,a.description,a.pv,a.etat,a.filename)"
			+"from Annonce a WHERE  a.etat='valide'")
	List<Annonce> listAnnonces();
	
	List<Annonce>findAllByClientname(String nom);
}
