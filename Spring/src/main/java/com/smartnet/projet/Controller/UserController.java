package com.smartnet.projet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.validation.Valid;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.smartnet.projet.Model.User;
import com.smartnet.projet.Repository.UserRepository;
import com.smartnet.projet.Service.UserDetailsImpl;
import com.smartnet.projet.Service.UserService;
import com.smartnet.projet.domaine.Message;
import com.smartnet.projet.exceptipon.ResourceNotFoundException;
import com.smartnet.projet.request.LoginRequest;
import com.smartnet.projet.request.RegisterRequest;
import com.smartnet.projet.security.JwtTokenUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import com.smartnet.projet.domaine.JwtResponse;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {


	@Autowired
	  private UserRepository userRepository ;
	 @Autowired private UserService userService;
	 @Autowired     ServletContext context;
	 @Autowired	    PasswordEncoder encoder;
	 @Autowired 	AuthenticationManager authenticationManager;
	 @Autowired	JwtTokenUtil jwtUtils;
	
	//get all user
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
    // create user rest api
    @PostMapping("/users")
	public User createUser(@Validated @RequestBody User user) {

	
	return userRepository.save(user);
		}
		
    //authentification 
	 @GetMapping("/users/auth/{name}")
	 public ResponseEntity<User> login(@PathVariable String name) {
	        Optional<User> user = userService.login(name);
	        return user.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                             .build());
	    }
		
    // get user by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<User>  getUserById(@PathVariable Long id) {
	User user =userRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("user not exist with id ="+id));
	return ResponseEntity.ok(user);
		}
		  
	//update user REST API
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
			
		user.setId(userDetails.getId());
		user.setCode(userDetails.getCode());
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setRole(userDetails.getRole());
		user.setActive(userDetails.isActive());
		


			
			
			User updatedUser = userRepository.save(user);
			return ResponseEntity.ok(updatedUser);
		}
	

		


	// delete User rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
	User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
			
			userRepository.delete(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	@PostMapping("/users/sec")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new Message("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new Message("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setRole("CLIENT");
		user.setActive(true);
			
		userRepository.save(user);

		return ResponseEntity.ok(new Message("User registered successfully!"));
	}	  
	

	@PostMapping("/users/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest data) {
		System.out.println("aaaa");
		System.out.println(data.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						data.getUsername(),
						data.getPassword())
			
				);
		  System.out.println("bbbbb");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 userDetails.getRole()));
	}


	@GetMapping("/users/pwd")
	public ResponseEntity<?> generetePassword()throws Exception	{
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(16);
		String cryptPwd=encoder.encode("12121212");
		return ResponseEntity.ok(new Message(cryptPwd));
				
		}
	
	
}
