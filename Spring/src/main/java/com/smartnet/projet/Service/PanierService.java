package com.smartnet.projet.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.smartnet.projet.Model.Lpanier;
import com.smartnet.projet.Model.Panier;
import com.smartnet.projet.Model.Compteur;
import com.smartnet.projet.Repository.LpanierRepository;
import com.smartnet.projet.Repository.PanierRepository;
import com.smartnet.projet.Repository.CompteurRepository;



@Service
@Transactional
public class PanierService {
	@Autowired
	PanierRepository PanRepository;
	@Autowired
	LpanierRepository lprepository;
	@Autowired
	CompteurRepository comrepository;
	
	public List<Panier> getAll() {
		System.out.println("Get all Paniers .........");
    	return PanRepository.findAll(Sort.by("numero").ascending());	    	
    }
	
	
    public Optional<Panier> findById(long id) {
        return PanRepository.findById(id);
    }
    
    
    
   
    public long save (Panier Panier) {
    	List<Lpanier> lpaniers=Panier.getLpaniers();
    	for(Lpanier lp:lpaniers) {
    		lp.setNumero(Panier.getNumero());
    		lprepository.save(lp);
    	}
Optional<Compteur> CompteurInfo=comrepository.findByAnnee(Panier.getAnnee());
	if(CompteurInfo.isPresent()) {
		Compteur compteur=CompteurInfo.get();	
		compteur.setNumpanier(compteur.getNumpanier()+1);
		comrepository.save(compteur);
		}
	return PanRepository.save(Panier).getId();
    }
	

    public List<Panier> findByNom(String nom) {
        return PanRepository.findAllByNom(nom);
    }

   
    public void delete(long  id) {
        Optional<Panier> pan = PanRepository.findById(id);
        pan.ifPresent(PanRepository::delete);
    }
}
