package com.sirsavio.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirsavio.estudo.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
}