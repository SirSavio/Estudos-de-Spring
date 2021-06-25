package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirsavio.estudo.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	
}