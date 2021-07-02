package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirsavio.estudo.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
	
}