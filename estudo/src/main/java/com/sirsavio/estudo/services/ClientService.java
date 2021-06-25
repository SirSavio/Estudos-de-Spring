package com.sirsavio.estudo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.Client;
import com.sirsavio.estudo.repositories.ClientRepository;
import com.sirsavio.estudo.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repo;
	public Client findById(Integer id) {
		Optional<Client> client = repo.findById(id);
		
		return client.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName())); 
	}
}
