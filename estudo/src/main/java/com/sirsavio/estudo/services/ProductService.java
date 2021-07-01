package com.sirsavio.estudo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.Category;
import com.sirsavio.estudo.domain.Product;
import com.sirsavio.estudo.repositories.CategoryRepository;
//import com.sirsavio.estudo.dto.ProductDTO;
import com.sirsavio.estudo.repositories.ProductRepository;
import com.sirsavio.estudo.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	@Autowired
	private CategoryRepository categoryRepository;
	public Product findById(Integer id) {
		Optional<Product> cate = repo.findById(id);
		
		return cate.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName())); 
	}
	
//	public Product create(Product obj) {
//		obj.setId(null);
//		return repo.save(obj);
//	}
//	
//	public Product update(Product obj) {
//		Product newObj = findById(obj.getId());
//		merge(newObj, obj);
//
//		return repo.save(newObj);
//	}
//	
//	public void delete(Integer id) {
//		try {
//			repo.deleteById(id);
//		} catch (Exception e) {
//			throw new DataIntegrityException("Não é possível apagar porque há entidades relacioandas!");
//		}
//	}
//	
//	public List<Product> findAll(){
//		return repo.findAll();
//	}
//	
//	public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage,  Direction.valueOf(direction), orderBy);
//		return repo.findAll(pageRequest);
//	}
//	
//	public Product fromDTO(ProductDTO obj) {
//		return new Product(obj.getId(), obj.getName());
//	}
//	
//	private void merge(Product newObj, Product obj) {
//		newObj.setName(obj.getName());
//	}
	public Page<Product> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,  Direction.valueOf(direction), orderBy);
		List<Category> cate = categoryRepository.findAllById(ids);
		return repo.search(name, cate, pageRequest);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
