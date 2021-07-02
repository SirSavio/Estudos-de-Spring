package com.sirsavio.estudo.domain.enums;

public enum Status {
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String type;
	
	private Status(int cod, String type) {
		this.cod = cod;
		this.type = type;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getType() {
		return this.type;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(Status ct : Status.values()) {
			if(cod.equals(ct.getCod())) return ct;
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
