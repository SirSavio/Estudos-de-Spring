package com.sirsavio.estudo.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sirsavio.estudo.domain.Client;
import com.sirsavio.estudo.dto.ClientDTO;
import com.sirsavio.estudo.dto.ClientNewDTO;
import com.sirsavio.estudo.services.ClientService;
import com.sirsavio.estudo.services.exceptions.DataIntegrityException;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	ClientService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> show(@PathVariable Integer id) { 
		Client client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody ClientNewDTO objDTO){
		Client obj = service.fromDTO(objDTO);
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO objDTO, @PathVariable Integer id){
		Client obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			service.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma catagoria que contem produtos!");
		}
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> index() { 
		List<Client> cat = service.findAll();
		List<ClientDTO> list = cat.stream().map(cate -> new ClientDTO(cate)).toList();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClientDTO>> showPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) { 
		Page<Client> cat = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClientDTO> list = cat.map(cate -> new ClientDTO(cate));
		return ResponseEntity.ok().body(list);
	}
}
