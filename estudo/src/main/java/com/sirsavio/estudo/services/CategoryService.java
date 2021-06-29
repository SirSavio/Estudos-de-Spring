package com.sirsavio.estudo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.Category;
import com.sirsavio.estudo.repositories.CategoryRepository;
import com.sirsavio.estudo.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	public Category findById(Integer id) {
		Optional<Category> cate = repo.findById(id);
		
		return cate.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName())); 
	}
	
	public Category create(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Category update(Category obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Category> findAll(){
		return repo.findAll();
	}
}
