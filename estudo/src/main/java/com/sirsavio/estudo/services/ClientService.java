package com.sirsavio.estudo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.Client;
import com.sirsavio.estudo.dto.ClientDTO;
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
	
	public Client create(Client obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Client update(Client obj) {
		Client newObj = findById(obj.getId());
		merge(newObj, obj);

		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Client> findAll(){
		return repo.findAll();
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,  Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Client fromDTO(ClientDTO obj) {
		return new Client(obj.getId(), obj.getName(), obj.getEmail(), null, null);
	}
	
	private void merge(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
