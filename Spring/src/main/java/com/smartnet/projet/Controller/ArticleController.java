package com.smartnet.projet.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;
 
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.smartnet.projet.Model.Article;
import com.smartnet.projet.Repository.ArticleRepository;
import com.smartnet.projet.Service.ArticleService;
import com.smartnet.projet.dto.ListArticle;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;



//@cross permettre spingboot à communiquer averc angular 
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {

	
	@Autowired
   private ArticleRepository articleRepository ;
	@Autowired
	ServletContext context;
	@Autowired
	private ArticleService artService;
	
	//get all article
	@GetMapping("/articles")
	public List<ListArticle> getAll(){
		return articleRepository.listArticle();  
	}
	
	//get all art pou la vérification
	@GetMapping("/articles/all")
	public List<Article> getAllCategories(){
		return articleRepository.findAll();
	}
	//find by code 
	public Optional<Article> findByCode(String code){
		return articleRepository.findByCode(code);
	}
	
	// create article rest api
	@PostMapping("/articles")
	 public long createArticle (@RequestParam("file") MultipartFile file,
			 @RequestParam("article") String article) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Save Article.............");
	    Article arti = new ObjectMapper().readValue(article, Article.class);
	    boolean isExit = new File(context.getRealPath("/Imagess/")).exists();
	    if (!isExit)
	    {
	    	new File (context.getRealPath("/Imagess/")).mkdir();
	    	System.out.println("mk dir Imagess.............");
	    }
	    System.out.println("Save Article ............");
	    String filename = file.getOriginalFilename();
	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	    File serverFile = new File (context.getRealPath("/Imagess/"+File.separator+newFileName));
	    try
	    {
	    	System.out.println("Image");
	    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
	    	 
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    System.out.println("Save Article .............");
	    arti.setFilename(newFileName);
		return artService.save(arti);
		
	}

	//pour récupérer l'image de l'article 
	@GetMapping(path="Imgarticles/{id}")
	public byte[]getPhoto(@PathVariable("id") long id) throws Exception{
		Article article =articleRepository.findById(id).get(); 
		return Files.readAllBytes(Paths.get(context.getRealPath("/Imagess/")+article.getFilename()));
	}
	
	//pour récupérer l'image de l'article 
		@GetMapping(path="Imgarticlesd/{code}")
		public byte[]getPhoto2(@PathVariable("code") String code) throws Exception{
			Article article =articleRepository.findByCode(code).get(); 
			return Files.readAllBytes(Paths.get(context.getRealPath("/Imagess/")+article.getFilename()));
		}
	
	

	
	
	
	 // get article by id rest api
	@GetMapping("/articles/{id}")
     public ResponseEntity<Article>  getArticleById(@PathVariable Long id) {
		Article article =articleRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("article not exist with id ="+id));
	 return ResponseEntity.ok(article);
	}
	  
	//update article REST API
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article articleDetails){
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("article not exist with id :" + id));
		
		article.setId(articleDetails.getId());
		article.setCode(articleDetails.getCode());
		article.setLibelle(articleDetails.getLibelle());
		article.setPa(articleDetails.getPa());
		article.setPv(articleDetails.getPv());
		article.setTva(articleDetails.getTva());
		article.setStock(articleDetails.getStock());
		article.setLibcateg(articleDetails.getLibcateg());
		article.setLibscateg(articleDetails.getLibscateg());
		article.setLibfour(articleDetails.getLibfour());
		article.setFilename(articleDetails.getFilename());

		
		Article updatedArticle = articleRepository.save(article);
		return ResponseEntity.ok(updatedArticle);
	}
 

	// delete article rest api
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteArticle(@PathVariable Long id){
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("article not exist with id :" + id));
		
		articleRepository.delete(article);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	 @GetMapping("/articles/7/{code}")public int getCode(@PathVariable String code) {
        System.out.println("getting numbers ");
	    int x=articleRepository.nbre(code);
	    System.out.println(x); 
	    if(x==0) 
	    { 
	    	return 0;
	    }
	    else 
	    {
	    	return articleRepository.max(code); 
	    } 
	 }
		

}
