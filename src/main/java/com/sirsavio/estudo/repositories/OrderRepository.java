package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sirsavio.estudo.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}