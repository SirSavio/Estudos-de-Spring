package com.sirsavio.estudo.domain.enums;

public enum ClientType {
	PF(1, "PF"),
	PJ(2, "PJ");
	
	private int cod;
	private String type;
	
	private ClientType(int cod, String type) {
		this.cod = cod;
		this.type = type;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getType() {
		return this.type;
	}
	
	public static ClientType toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(ClientType ct : ClientType.values()) {
			if(cod.equals(ct.getCod())) return ct;
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
