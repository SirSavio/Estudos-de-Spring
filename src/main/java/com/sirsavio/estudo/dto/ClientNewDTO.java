package com.sirsavio.estudo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sirsavio.estudo.services.validation.ClientCreate;

@ClientCreate
public class ClientNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Nome é obrigatório")
	@Length(min = 5, max = 120, message = "O nome deve possuir de 5 a 120 caracteres")
	private String name;
	
	@NotEmpty(message = "Email é obrigatório")
	@Email
	private String email; 
	
	@NotEmpty(message = "Email é obrigatório")
	private String document;
	
	private Integer type; 
	
	@NotEmpty(message = "Email é obrigatório")
	private String street;
	
	@NotEmpty(message = "Email é obrigatório")
	private String number; 
	
	private String complement;
	private String neigh;
	
	@NotEmpty(message = "Email é obrigatório")
	private String zipcode;
	
	@NotEmpty(message = "Email é obrigatório")
	private String phone1;
	private String phone2;
	private String phone3;
	
	private Integer cidadeId;
	
	public ClientNewDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
}
