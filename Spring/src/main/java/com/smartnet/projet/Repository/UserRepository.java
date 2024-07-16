package com.smartnet.projet.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartnet.projet.Model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

	Optional<User> findByCode(String code);
	
	Optional<User> findByUsername(String name);

	List<User> findAllByEmail(String email);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	

}
