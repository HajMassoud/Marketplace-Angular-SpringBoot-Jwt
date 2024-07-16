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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
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

import com.smartnet.projet.Repository.ClientRepository;
import com.smartnet.projet.Repository.UserRepository;
import com.smartnet.projet.Service.ClientService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartnet.projet.Model.Client;
import com.smartnet.projet.Model.User;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	  private ClientRepository clientRepository ;
	@Autowired // a chaque fois lorsqu'on ajoute une repository il faux ajouter l'annotation @Autowired !!!!!
	  private UserRepository userRepository ;
	@Autowired
		private ClientService clientService ;
	@Autowired
	ServletContext context;
	@Autowired	    PasswordEncoder encoder;
	
	  @RequestMapping("/aa")
	     public String home(){
	         return "Hello World!";
	     }
	
	//get all client
	@GetMapping("/clients")
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
    // create client rest api
    @PostMapping("/clients")
	public Client createClient(@Validated @RequestBody Client client) {
    	
    	User user = new User();
    	
    	user.setEmail(client.getEmail());
    	user.setCode(client.getCode());
    	user.setUsername(client.getClientname());
    	user.setPassword(client.getPwd());
    	user.setRole("CLIENT");
    	userRepository.save(user);
	
	return clientRepository.save(client);
	
	
		}
		
 // create CLIENT REGISTER rest api
 	@PostMapping("/clients/register")
 	 public long createClient (@RequestParam("file") MultipartFile file,
 			 @RequestParam("client") String client) throws JsonParseException , JsonMappingException , Exception
 	 {
 		 System.out.println("Save Clinent.............");
 	    Client cli = new ObjectMapper().readValue(client, Client.class);
 	    boolean isExit = new File(context.getRealPath("/ImagessClient/")).exists();
 	    if (!isExit)
 	    {
 	    	new File (context.getRealPath("/ImagessClient/")).mkdir();
 	    	System.out.println("mk dir Imagess.............");
 	    }
 	    System.out.println("Save Client.............");
 	    String filename = file.getOriginalFilename();
 	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
 	    File serverFile = new File (context.getRealPath("/ImagessClient/"+File.separator+newFileName));
 	    try
 	    {
 	    	System.out.println("Image");
 	    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
 	    	 
 	    }catch(Exception e) {
 	    	e.printStackTrace();
 	    }
 	    System.out.println("Save Article .............");
 	    cli.setFilename(newFileName);
 	     User user = new User();
 	        user.setId(cli.getId());
 	     	user.setEmail(cli.getEmail());
   	    	user.setCode(cli.getCode());
   	    	user.setUsername(cli.getClientname());
   	    	user.setPassword(encoder.encode(cli.getPwd()));
   	    	user.setActive(true);
   	    	user.setRole("CLIENT");
   	    	userRepository.save(user);
 	    
 		return clientService.save(cli);
 		
 	}
 	 		
 	
 	
 	
 	//pour récupérer l'image du client *****vérifier long id 
 		@GetMapping(path="Imgclients/{id}")
 		public byte[]getPhoto(@PathVariable("id") long id) throws Exception{
 			Client client =clientRepository.findById(id).get(); 
 			return Files.readAllBytes(Paths.get(context.getRealPath("/ImagessClient/")+client.getFilename()));
 		}
 		
 		//pour récupérer l'image du client avec son username  *****vérifier long id 
 		@GetMapping(path="Imgclientss/{clientname}")
 		public byte[]getPhoto(@PathVariable("clientname") String clientname) throws Exception{
 			Client client =clientRepository.findByClientname(clientname).get(); 
 			return Files.readAllBytes(Paths.get(context.getRealPath("/ImagessClient/")+client.getFilename()));
 		}
 		
 		
		
    // get client by id rest api
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client>  getClientById(@PathVariable Long id) {
	Client client =clientRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Client not exist with id ="+id));
	return ResponseEntity.ok(client);
		}
		  
	//update client REST API
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
		Client client = clientRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));
			
			client.setId(clientDetails.getId());
			client.setCode(clientDetails.getCode());
			client.setClientname(clientDetails.getClientname());
			client.setAdresse(clientDetails.getAdresse());
			client.setTel(clientDetails.getTel());
			client.setEmail(clientDetails.getEmail());
			client.setFax(clientDetails.getFax());
			client.setPwd(clientDetails.getPwd());
	 Optional<User> users = userRepository.findByCode(clientDetails.getCode());
	 if (users.isPresent()) {
		 User user =users.get();
			user.setEmail(client.getEmail());
	    	user.setUsername(client.getClientname());
	    	user.setPassword(client.getPwd());
	    	user.setRole("CLIENT");
	    	userRepository.save(user);
	 }
			
			
			Client updatedClient = clientRepository.save(client);
			return ResponseEntity.ok(updatedClient);
		}
		


	// delete Client rest api
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
	Client client = clientRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("client not exist with id :" + id));
			
			clientRepository.delete(client);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

	@GetMapping("/clients/clientname/{clientname}")
	public ResponseEntity<Client>  getClientByClientname(@PathVariable String clientname) {
	Client client =clientRepository.findByClientname(clientname)
					.orElseThrow(()-> new ResourceNotFoundException("user not exist with id ="+clientname));
	return ResponseEntity.ok(client);
		}

	
}
