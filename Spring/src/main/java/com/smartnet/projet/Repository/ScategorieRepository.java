package com.smartnet.projet.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartnet.projet.Model.Scategorie;
import com.smartnet.projet.dto.ListCategorie;

@Repository
public interface ScategorieRepository extends JpaRepository <Scategorie, Long>{

	List<Scategorie> findAllByCode(String code);

	List<Scategorie> findAllByLibcateg(String libcateg);

	List<Scategorie> findAllByLibelle(String libelle);
	
	public Optional<Scategorie> findByCode(String code);
	
	@Query(value= "SELECT new com.smartnet.projet.dto.ListCategorie (a.id,a.code,a.libelle,b.libelle,b.code) from Scategorie a join Categorie b on a.libcateg=b.libelle")
     public  List<ListCategorie> listScateg();

	@Query(value="SELECT t from Scategorie t where t.libcateg= :code")
	public List<Scategorie> findByCateg(@Param("code") String code);
	
	@Query(value="SELECT count(*) FROM Scategorie WHERE code =:code")
	public int nbre(@Param("code") String code);
	
	@Query(value="SELECT max(code) FROM Scategorie WHERE code =:code")
	public int max(@Param("code") String code);

	

}
