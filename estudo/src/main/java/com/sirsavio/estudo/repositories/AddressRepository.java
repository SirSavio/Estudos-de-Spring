package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirsavio.estudo.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
}