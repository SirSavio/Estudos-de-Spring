package com.sirsavio.estudo.services;

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
}
