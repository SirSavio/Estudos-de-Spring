package com.sirsavio.estudo.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.sirsavio.estudo.domain.enums.Status;

@Entity
public class BoletoPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date paymentDate;
	
	public BoletoPayment() {}

	public BoletoPayment(Integer id, Status status, Order order, Date dueDate, Date paymentDate) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		
		// TODO Auto-generated constructor stub
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
