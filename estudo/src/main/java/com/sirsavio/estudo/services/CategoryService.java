package com.sirsavio.estudo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirsavio.estudo.domain.Category;
import com.sirsavio.estudo.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	public Optional<Category> findById(Integer id) {
		Optional<Category> cate = repo.findById(id);
		return cate;
	}
}
