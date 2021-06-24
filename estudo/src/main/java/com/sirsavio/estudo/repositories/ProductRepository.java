package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirsavio.estudo.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}