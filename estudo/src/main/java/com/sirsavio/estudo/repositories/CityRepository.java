package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirsavio.estudo.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	
}