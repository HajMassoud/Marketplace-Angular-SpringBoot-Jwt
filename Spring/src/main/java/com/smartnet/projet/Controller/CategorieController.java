package com.smartnet.projet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.smartnet.projet.Model.Categorie;
import com.smartnet.projet.Repository.CategorieRepository;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {

	
	@Autowired
   private CategorieRepository categorieRepository ;
	
	//get all cat
	@GetMapping("/categories")
	public List<Categorie> getAllCategories(){
		return categorieRepository.findAll();
	}
	
	// create categorie rest api
	@PostMapping("/categories")
	public Categorie createCategorie(@Validated @RequestBody Categorie categorie) {
		return categorieRepository.save(categorie);
	}
	
	
	 // get catgeorie by id rest api
	@GetMapping("/categories/{id}")
     public ResponseEntity<Categorie>  getCategorieById(@PathVariable Long id) {
		Categorie categorie =categorieRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Categorrie not exist with id ="+id));
	 return ResponseEntity.ok(categorie);
	}
	  
	//update categorie REST API
	@PutMapping("/categories/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable Long id, @RequestBody Categorie categorieDetails){
		Categorie categorie = categorieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("categorie not exist with id :" + id));
		
		categorie.setId(categorieDetails.getId());
		categorie.setCode(categorieDetails.getCode());
		categorie.setLibelle(categorieDetails.getLibelle());
		
		Categorie updatedCategorie = categorieRepository.save(categorie);
		return ResponseEntity.ok(updatedCategorie);
	}
 

	// delete categorie rest api
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCategorie(@PathVariable Long id){
		Categorie categorie = categorieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("categorie not exist with id :" + id));
		
		categorieRepository.delete(categorie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
