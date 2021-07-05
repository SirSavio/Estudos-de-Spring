package com.sirsavio.estudo.domain.enums;

public enum Profile {
	ADMIN(1, "ROLE_ADMIN"),
	CLIENT(2, "ROLE_CLIENT");
	
	private int cod;
	private String type;
	
	private Profile(int cod, String type) {
		this.cod = cod;
		this.type = type;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getType() {
		return this.type;
	}
	
	public static Profile toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(Profile ct : Profile.values()) {
			if(cod.equals(ct.getCod())) return ct;
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
