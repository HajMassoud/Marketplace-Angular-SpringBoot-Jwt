package com.smartnet.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartnet.projet.Model.Lpanier;
import com.smartnet.projet.Repository.LpanierRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LpanierController {

	@Autowired
	  private LpanierRepository LpanierRepository ;
	//get all fournisseurs
		@GetMapping("/lpaniers")
		public List<Lpanier> getAllFournisseurs(){
			return LpanierRepository.findAll();
		}
		 // get Lpanier  by numero rest api

		@GetMapping("/lpaniers/numero/{numero}")
		public ResponseEntity<List<Lpanier>> getLpaniereByNumero(@PathVariable int numero) {
			return new ResponseEntity<List<Lpanier>>(LpanierRepository.findAllByNumero(numero), HttpStatus.OK);
		}
		
		
}
