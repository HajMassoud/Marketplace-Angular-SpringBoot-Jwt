package com.smartnet.projet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.smartnet.projet.dto.ListCategorie;
import com.smartnet.projet.Model.Scategorie;
import com.smartnet.projet.Repository.ScategorieRepository;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ScategorieController {


	
	@Autowired
   private ScategorieRepository scategorieRepository ;
	
	//get all scat
	@GetMapping("/scategories")
	public List<ListCategorie> getAllScategories(){
		return scategorieRepository.listScateg();
	}
	
	// create scategorie rest api
	@PostMapping("/scategories")
	public Scategorie createScategorie(@Validated @RequestBody Scategorie scategorie) {
		return scategorieRepository.save(scategorie);
	}
	
	
	 // get scatgeorie by id rest api
	@GetMapping("/scategories/{id}")
     public ResponseEntity<Scategorie>  getScategorieById(@PathVariable Long id) {
		Scategorie scategorie =scategorieRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Sous categorrie not exist with id ="+id));
	 return ResponseEntity.ok(scategorie);
	}
	

	

	 // get scatgeorie by Ccateg rest api

	@GetMapping("/scategories/libcateg/{libcateg}")
	public ResponseEntity<List<Scategorie>> getScategorieByLibcateg(@PathVariable String libcateg) {
		return new ResponseEntity<List<Scategorie>>(scategorieRepository.findAllByLibcateg(libcateg), HttpStatus.OK);
	}
	
	 // get scatgeorie by code rest api

	@GetMapping("/scategories/code/{code}")
	public ResponseEntity<List<Scategorie>> getScategorieByCode(@PathVariable String code) {
		return new ResponseEntity<List<Scategorie>>(scategorieRepository.findAllByCode(code), HttpStatus.OK);
	}
	 // get scatgeorie by libelle rest api

	@GetMapping("/scategories/libelle/{libelle}")
	public ResponseEntity<List<Scategorie>> getScategorieByLibelle(@PathVariable String libelle) {
		return new ResponseEntity<List<Scategorie>>(scategorieRepository.findAllByLibelle(libelle), HttpStatus.OK);
	}
	  
	
	//update scategorie REST API
	@PutMapping("/scategories/{id}")
	public ResponseEntity<Scategorie> updateScategorie(@PathVariable Long id, @RequestBody Scategorie scategorieDetails){
		Scategorie scategorie = scategorieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("sous categorie not exist with id :" + id));
		
		scategorie.setId(scategorieDetails.getId());
		scategorie.setCode(scategorieDetails.getCode());
		scategorie.setLibelle(scategorieDetails.getLibelle());
		scategorie.setLibcateg(scategorieDetails.getLibcateg());
	
		
		Scategorie updatedScategorie = scategorieRepository.save(scategorie);
		return ResponseEntity.ok(updatedScategorie);
	}
	

	// delete scategorie rest api
	@DeleteMapping("/scategories/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteScategorie(@PathVariable Long id){
		Scategorie scategorie = scategorieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("sous categorie not exist with id :" + id));
		
		scategorieRepository.delete(scategorie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	//ok 
	@GetMapping("/scategories/cc/{code}")
	public ResponseEntity<List<Scategorie>> listCateg(@PathVariable String code){
		List<Scategorie> scategories =scategorieRepository.findByCateg(code);
		return new ResponseEntity<List<Scategorie>>(scategories, HttpStatus.OK);
	}
	
	
	//list des scateg
	@GetMapping("/scategories/{code}")
	public ResponseEntity<Scategorie> getScategorieBycode(@PathVariable String code) throws ResourceNotFoundException{
		Scategorie scategorie =scategorieRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Scaytegorie not found"));
		return ResponseEntity.ok().body(scategorie);
	}
	
	
	 @GetMapping("/scategories/7/{code}")public int getCode(@PathVariable String code) {
	        System.out.println("getting numbers ");
		    int x=scategorieRepository.nbre(code);
		    System.out.println(x); 
		    if(x==0) { return 0; }
		    else { return scategorieRepository.max(code); } 
		 }

}
