package com.smartnet.projet.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartnet.projet.Model.Annonce;
import com.smartnet.projet.Repository.AnnonceRepository;
import com.smartnet.projet.Service.AnnonceService;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AnnonceController {
	@Autowired
	private AnnonceRepository annonceRepository ;
	@Autowired
	ServletContext context;
	@Autowired
	private AnnonceService annonService;
	
	@GetMapping("/annonces/all")
	public List<Annonce> getAllAnnonces(){
		return annonceRepository.findAll();
	}
	
	@GetMapping("/annoncesvld")
	public List<Annonce> getAll(){
		return annonceRepository.listAnnonces();  
	}

	
	@PostMapping("/annonces/client")
	 public long createAnnonce (@RequestParam("file") MultipartFile file,
			 @RequestParam("annonce") String annonce) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Save Annonce.............");
	    Annonce annon = new ObjectMapper().readValue(annonce, Annonce.class);
	    boolean isExit = new File(context.getRealPath("/ImagesAnnonce/")).exists();
	    if (!isExit)
	    {
	    	new File (context.getRealPath("/ImagesAnnonce/")).mkdir();
	    	System.out.println("mk dir ImagesAnnonce.............");
	    }
	    System.out.println("Save Annonce.............");
	    String filename = file.getOriginalFilename();
	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	    File serverFile = new File (context.getRealPath("/ImagesAnnonce/"+File.separator+newFileName));
	    try
	    {
	    	System.out.println("Image");
	    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
	    	 
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    System.out.println("Save Annonce.............");
	    annon.setFilename(newFileName);
		return annonService.save(annon);
		
	}

	 ////////////////////////////////////////////////////////////
	@GetMapping(path="Imgannonces/{id}")
	public byte[]getPhoto(@PathVariable("id") long id) throws Exception{
		Annonce annonce =annonceRepository.findById(id).get(); 
		return Files.readAllBytes(Paths.get(context.getRealPath("/ImagesAnnonce/")+annonce.getFilename()));
	}
	
	
	//////////////////////////////////////////////////
	@PutMapping("/annonces/update/{id}")
	public ResponseEntity<Annonce> updateAnnonce(@PathVariable Long id, @RequestBody Annonce annonceDetails){
		Annonce annonce = annonceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Annonce not exist with id :" + id));
		
		annonce.setEtat(annonceDetails.getEtat());
	
		
		Annonce updatedAnnonce = annonceRepository.save(annonce);
		return ResponseEntity.ok(updatedAnnonce);
	}

	@DeleteMapping("/annonces/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAnnonce(@PathVariable Long id){
		Annonce annonce = annonceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("annonce not exist with id :" + id));
		
		annonceRepository.delete(annonce);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	//update annonce REST API
		@PutMapping("/annonces/{id}")
		public ResponseEntity<Annonce> updatAnnonce(@PathVariable Long id, @RequestBody Annonce annonceDetails){
			Annonce annonce = annonceRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Annonce not exist with id :" + id));
			
			annonce.setId(annonceDetails.getId());
			annonce.setClientname(annonceDetails.getClientname());
			annonce.setLibelle(annonceDetails.getLibelle());
			annonce.setAdresse(annonceDetails.getAdresse());
			annonce.setTel1(annonceDetails.getTel1());
			annonce.setTel2(annonceDetails.getTel2());
			annonce.setDescription(annonceDetails.getDescription());
			annonce.setEtat(annonceDetails.getEtat());
			annonce.setPv(annonceDetails.getPv());
			

			
			
			Annonce updatedAnnonce = annonceRepository.save(annonce);
			return ResponseEntity.ok(updatedAnnonce);
		}
		
		// get annonce by id rest api
		@GetMapping("/annonces/{id}")
	     public ResponseEntity<Annonce>  getAnnonceById(@PathVariable Long id) {
			Annonce annonce =annonceRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("annonce not exist with id ="+id));
		 return ResponseEntity.ok(annonce);
		}
		
		@GetMapping("/annonces/nom/{nom}")
		public ResponseEntity<List<Annonce>> getAnnonceByClientname(@PathVariable String nom) {
			return new ResponseEntity<List<Annonce>>(annonceRepository.findAllByClientname(nom), HttpStatus.OK);
		}


}
