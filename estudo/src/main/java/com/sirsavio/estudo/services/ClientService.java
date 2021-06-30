package com.sirsavio.estudo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.Address;
import com.sirsavio.estudo.domain.City;
import com.sirsavio.estudo.domain.Client;
import com.sirsavio.estudo.domain.enums.ClientType;
import com.sirsavio.estudo.dto.ClientDTO;
import com.sirsavio.estudo.dto.ClientNewDTO;
import com.sirsavio.estudo.repositories.AddressRepository;
import com.sirsavio.estudo.repositories.ClientRepository;
import com.sirsavio.estudo.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repo;
	@Autowired
	private AddressRepository addressRepository;
	public Client findById(Integer id) {
		Optional<Client> client = repo.findById(id);
		
		return client.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName())); 
	}
	
	@Transactional
	public Client create(Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		addressRepository.saveAll(obj.getAddresses());
		
		return obj;
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
	
	public Client fromDTO(ClientNewDTO obj) {
		Client client = new Client(null, obj.getName(), obj.getEmail(), obj.getDocument(), ClientType.toEnum(obj.getType()));
		City city = new City(obj.getCidadeId(), null, null);
		Address address = new Address(null, obj.getStreet(), obj.getNumber(), obj.getComplement(), obj.getNeigh(), obj.getZipcode(), client, city);
		
		client.getAddresses().add(address);
		client.getPhones().add(obj.getPhone1());
		
		if(obj.getPhone2() != null) client.getPhones().add(obj.getPhone2());
		if(obj.getPhone3() != null) client.getPhones().add(obj.getPhone3());
		
		return client;
	}
	
	private void merge(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
