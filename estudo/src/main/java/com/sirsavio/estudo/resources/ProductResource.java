package com.sirsavio.estudo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sirsavio.estudo.domain.Product;
import com.sirsavio.estudo.dto.ProductDTO;
import com.sirsavio.estudo.resources.utils.URL;
import com.sirsavio.estudo.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> show(@PathVariable Integer id) { 
		Product cat = service.findById(id);
		return ResponseEntity.ok().body(cat);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProductDTO>> showPage(
			@RequestParam(value = "name", defaultValue = "0") String name, 
			@RequestParam(value = "categories", defaultValue = "0") String categories	, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) { 
		List<Integer> listIds = URL.decodeStringToInteger(categories);
		name = URL.decodeParam(name);
		System.out.println(categories);
		Page<Product> prods = service.search(name, listIds, page, linesPerPage, orderBy, direction);
		Page<ProductDTO> list = prods.map(prod -> new ProductDTO(prod));
		return ResponseEntity.ok().body(list);
	}
}
