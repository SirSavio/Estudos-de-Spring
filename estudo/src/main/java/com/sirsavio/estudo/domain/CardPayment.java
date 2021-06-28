package com.sirsavio.estudo.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.sirsavio.estudo.domain.enums.Status;

@Entity
public class CardPayment extends Payment{
	private static final long serialVersionUID = 1L;
	private Integer parcels;
	
	public CardPayment() {}
	
	public CardPayment(Integer id, Status status, Order order, Integer parcels) {
		super(id, status, order);
		this.setParcels(parcels);
	}

	public Integer getParcels() {
		return parcels;
	}

	public void setParcels(Integer parcels) {
		this.parcels = parcels;
	}
	
	
}
