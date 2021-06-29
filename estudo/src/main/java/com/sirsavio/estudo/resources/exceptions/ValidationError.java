package com.sirsavio.estudo.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> fields = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
	}
	
	public void addError(String name, String message) {
		this.fields.add(new FieldMessage(name, message));
	}
	
	public List<FieldMessage> getErrors() {
		return this.fields;
	}
	
}
