package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirsavio.estudo.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}