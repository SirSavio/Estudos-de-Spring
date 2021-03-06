package com.sirsavio.estudo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.Category;
import com.sirsavio.estudo.dto.CategoryDTO;
import com.sirsavio.estudo.repositories.CategoryRepository;
import com.sirsavio.estudo.services.exceptions.DataIntegrityException;
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
		Category newObj = findById(obj.getId());
		merge(newObj, obj);

		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possível apagar porque há entidades relacioandas!");
		}
	}
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,  Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Category fromDTO(CategoryDTO obj) {
		return new Category(obj.getId(), obj.getName());
	}
	
	private void merge(Category newObj, Category obj) {
		newObj.setName(obj.getName());
	}
}
