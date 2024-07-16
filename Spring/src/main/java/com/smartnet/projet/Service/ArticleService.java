package com.smartnet.projet.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartnet.projet.Model.Article;
import com.smartnet.projet.Repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {
	@Autowired
	ArticleRepository repository;
	
	
	public long save(Article article) {
		System.out.println("save ...........");
			Article art =new Article();
			art.setCode(article.getCode());
			art.setLibelle(article.getLibelle());
			art.setPa(article.getPa());
			art.setPv(article.getPv());
			art.setTva(article.getTva());
			art.setStock(article.getStock());
			art.setLibcateg(article.getLibcateg());
			art.setLibscateg(article.getLibscateg());
			art.setDescription(article.getDescription());
			art.setLibfour(article.getLibfour());
			art.setFilename(article.getFilename());
 
			return repository.save(art).getId();
            }




}
