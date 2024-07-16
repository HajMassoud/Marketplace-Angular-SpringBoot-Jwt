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


import com.smartnet.projet.Model.Fournisseur;
import com.smartnet.projet.Repository.FournisseurRepository;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FournisseurController {


	@Autowired
	  private FournisseurRepository fournisseurRepository ;
	
	//get all fournisseurs
	@GetMapping("/fournisseurs")
	public List<Fournisseur> getAllFournisseurs(){
		return fournisseurRepository.findAll();
	}
    // create fournisseur rest api
    @PostMapping("/fournisseurs")
	public Fournisseur createFournisseur(@Validated @RequestBody Fournisseur fournisseur) {
	return fournisseurRepository.save(fournisseur);
		}
		
		
    // get fournisseur by id rest api
	@GetMapping("/fournisseurs/{id}")
	public ResponseEntity<Fournisseur>  getCournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur =fournisseurRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("fournisseur not exist with id ="+id));
	return ResponseEntity.ok(fournisseur);
		}
		  
	//update fournisseur REST API
	@PutMapping("/fournisseurs/{id}")
	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseurDetails){
		Fournisseur fournisseur = fournisseurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not exist with id :" + id));
			
		fournisseur.setId(fournisseurDetails.getId());
		fournisseur.setCode(fournisseurDetails.getCode());
		fournisseur.setFourName(fournisseurDetails.getFourName());
		fournisseur.setAdresse(fournisseurDetails.getAdresse());
		fournisseur.setTel(fournisseurDetails.getTel());
		fournisseur.setEmail(fournisseurDetails.getEmail());
		fournisseur.setFax(fournisseurDetails.getFax());

			
			
		Fournisseur updatedFournisseur = fournisseurRepository.save(fournisseur);
			return ResponseEntity.ok(updatedFournisseur);
		}
		
  


	// delete fournisseur rest api
	@DeleteMapping("/fournisseurs/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFournisseur(@PathVariable Long id){
		Fournisseur fournisseur = fournisseurRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("fournisseur not exist with id :" + id));
			
		    fournisseurRepository.delete(fournisseur);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
