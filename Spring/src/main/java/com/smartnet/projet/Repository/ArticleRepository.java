package com.smartnet.projet.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartnet.projet.Model.Article;
import com.smartnet.projet.dto.ListArticle;

@Repository
public interface ArticleRepository extends JpaRepository <Article, Long> {


	Optional<Article> findByCode(String code);
	
	List<Article> findAllByLibelleContaining(String libelle);
	
	List<Article> findAllByLibcateg(String code);
	
	List<Article> findAllByLibscateg(String code);
	
	Optional<Article> findAllById(Long id);

	Optional<Article> findByLibelle(String libelle);
	
	
	@Query(value="SELECT new com.smartnet.projet.dto.ListArticle(a.id,a.code,a.libelle,a.filename,b.libelle,c.libelle,a.pa,a.pv,a.tva,a.stock)"
			+"from Article a, Scategorie b,Categorie c  WHERE  b.libcateg =c.libelle and a.libscateg=b.libelle")
	List<ListArticle> listArticle();

	@Query(value="SELECT count(*) FROM Article WHERE cscateg =:code")
	public int nbre(@Param("code") String code);
	
	@Query(value="SELECT max(code) FROM Article WHERE cscateg =:code")
	public int max(@Param("code") String code);


	
	

}