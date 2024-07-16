package com.smartnet.projet.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartnet.projet.Model.Annonce;
import com.smartnet.projet.Repository.AnnonceRepository;

@Service
@Transactional
public class AnnonceService {
	@Autowired
	AnnonceRepository repository;
	public long save(Annonce annonce) {
		System.out.println("save ...........");
			Annonce annon =new Annonce();
			annon.setClientname(annonce.getClientname());
			annon.setLibelle(annonce.getLibelle());
			annon.setAdresse(annonce.getAdresse());
			annon.setTel1(annonce.getTel1());
			annon.setTel2(annonce.getTel2());
			annon.setPv(annonce.getPv());
			annon.setDescription(annonce.getDescription());
			annon.setEtat("nonvalide");
			annon.setFilename(annonce.getFilename());
 
			return repository.save(annon).getId();
            }

}
