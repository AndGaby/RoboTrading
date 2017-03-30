package br.com.robotrading.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import br.com.robotrading.web.model.Cliente;

public class ClienteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Cliente.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		return;
	}

}
