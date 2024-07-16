package com.smartnet.projet.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartnet.projet.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

	Optional<Client> findByClientname(String clientname);


	

}