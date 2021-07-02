package com.sirsavio.estudo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sirsavio.estudo.domain.Client;
import com.sirsavio.estudo.domain.enums.ClientType;
import com.sirsavio.estudo.dto.ClientNewDTO;
import com.sirsavio.estudo.repositories.ClientRepository;
import com.sirsavio.estudo.resources.exceptions.FieldMessage;
import com.sirsavio.estudo.services.validation.utils.BR;

public class ClientCreateValidator implements ConstraintValidator<ClientCreate, ClientNewDTO> {
	@Autowired
	private ClientRepository repo;
	
	@Override
	public void initialize(ClientCreate ann) {
	}

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if(objDto.getType().equals(ClientType.PF.getCod()) && !BR.isValidCPF(objDto.getDocument())) {
			list.add(new FieldMessage("document", "CPF inválido"));
		}
		
		if(objDto.getType().equals(ClientType.PJ.getCod()) && !BR.isValidCPF(objDto.getDocument())) {
			list.add(new FieldMessage("document", "CNPJ inválido"));
		}
		
		Client aux = repo.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já cadastrado!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}