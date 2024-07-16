package com.smartnet.projet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartnet.projet.Model.Panier;
import com.smartnet.projet.Repository.PanierRepository;
import com.smartnet.projet.Service.PanierService;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PanierController {
	@Autowired
    private PanierService panierService;
	@Autowired
    private PanierRepository panierRepository;
	
 
 @GetMapping("/paniers")
    public List<Panier> list() {
	 System.out.println("Get all paniers...");
             return panierService.getAll();
   }
 	 
 @GetMapping("/paniers/{id}")
 public ResponseEntity<Panier> createPanier(@PathVariable long id) {
        Optional<Panier> panier = panierRepository.findById(id);
        return panier.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/paniers")
    public long save(@RequestBody Panier Panier) {
	 System.out.println("Save Panier...");
        return panierService.save(Panier);
    }

 @PutMapping("/paniers/{id}")
public ResponseEntity<Panier> updatePanier(@PathVariable Long id, @RequestBody Panier panierDetails){
			Panier panier = panierRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Panier not exist with id :" + id));
			
			panier.setId(panierDetails.getId());
			panier.setAnnee(panierDetails.getAnnee());
			panier.setNumero(panierDetails.getNumero());
			panier.setDate_mvt(panierDetails.getDate_mvt());
			panier.setNom(panierDetails.getNom());
			panier.setAdresse(panierDetails.getAdresse());
			panier.setSadresse(panierDetails.getSadresse());
			panier.setVille(panierDetails.getVille());
			panier.setCodep(panierDetails.getCodep());
			panier.setTel(panierDetails.getTel());
			panier.setTel1(panierDetails.getTel1());
			panier.setTotht(panierDetails.getTotht());
			panier.setTottva(panierDetails.getTottva());
			panier.setTotttc(panierDetails.getTotttc());
			panier.setModreg(panierDetails.getModreg());
			panier.setNumcarte(panierDetails.getNumcarte());
			
			
			Panier updatedPanier = panierRepository.save(panier);
			return ResponseEntity.ok(updatedPanier);
    }
 
	// delete panier rest api
	@DeleteMapping("/paniers/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePanier(@PathVariable Long id){
		Panier panier = panierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Panier not exist with id :" + id));
		
		panierRepository.delete(panier);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/paniers/nom/{nom}")
	public ResponseEntity<List<Panier>> getPaniereByNom(@PathVariable String nom) {
		return new ResponseEntity<List<Panier>>(panierRepository.findAllByNom(nom), HttpStatus.OK);
	}

   
     
}
