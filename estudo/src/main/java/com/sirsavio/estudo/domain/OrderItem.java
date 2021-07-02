package com.sirsavio.estudo.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	private Double discount;
	private Double price;
	private Integer quantity;
	
	public OrderItem() {}

	public OrderItem(Order order, Product product, Double discount, Integer quantity, Double price) {
		super();
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.discount = discount;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderItemPK getId() {
		return id;
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	public double getSubTotal(){
		return (this.price - this.discount) * this.quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

}
