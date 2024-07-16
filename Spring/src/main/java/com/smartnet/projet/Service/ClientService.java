package com.smartnet.projet.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartnet.projet.Model.Client;
import com.smartnet.projet.Repository.ClientRepository;

@Service
@Transactional
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	public long save(Client client) {
		System.out.println("save ...........");
			Client art =new Client();
			art.setCode(client.getCode());
			art.setClientname(client.getClientname());
			art.setAdresse(client.getAdresse());
			art.setTel(client.getTel());
			art.setEmail(client.getEmail());
			art.setFax(client.getFax());
			art.setPwd(client.getPwd());
			art.setFilename(client.getFilename());
 
			return repository.save(art).getId();
			
	}
		
}
