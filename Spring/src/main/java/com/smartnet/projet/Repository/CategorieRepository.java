package com.smartnet.projet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartnet.projet.Model.Categorie;



@Repository
public interface CategorieRepository extends JpaRepository <Categorie, Long> {
	

}
