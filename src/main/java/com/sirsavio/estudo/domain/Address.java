package com.sirsavio.estudo.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String street;
	private String number; 
	private String complement;
	private String neigh;
	private String zipcode;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	
	public Address(Integer id, String street, String number, String complement, String neigh, String zipcode,
			Client client, City city) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neigh = neigh;
		this.zipcode = zipcode;
		this.client = client;
		this.city = city;
	}


	public Address() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getNeigh() {
		return neigh;
	}


	public void setNeigh(String neigh) {
		this.neigh = neigh;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
	


	
}
