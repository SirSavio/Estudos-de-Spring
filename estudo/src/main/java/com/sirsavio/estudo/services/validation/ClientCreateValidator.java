package com.sirsavio.estudo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sirsavio.estudo.domain.enums.ClientType;
import com.sirsavio.estudo.dto.ClientNewDTO;
import com.sirsavio.estudo.resources.exceptions.FieldMessage;
import com.sirsavio.estudo.services.validation.utils.BR;

public class ClientCreateValidator implements ConstraintValidator<ClientCreate, ClientNewDTO> {
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

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}