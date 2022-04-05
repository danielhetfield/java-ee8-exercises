package com.linkedin.ejb;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//First type is the Annotation we would like this to apply to.
//Second type is the type of input to validate
public class PermittedManufacturerConstraintValidator implements ConstraintValidator<PermittedManufacturers, String> {

	private static String[] permittedManufacturers = {"CompanyA", "CompanyB"};
	
	@Override
	public boolean isValid(String inputText, ConstraintValidatorContext context) {
		return Arrays.asList(permittedManufacturers).contains(inputText);
	}
}
