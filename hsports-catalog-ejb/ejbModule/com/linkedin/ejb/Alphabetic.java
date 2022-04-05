package com.linkedin.ejb;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

//Required
@Documented
//Required
@Constraint(validatedBy = {})
//Now we can apply our pattern or list of patterns. invalid.aphabetic comes from validationMessages.properties file in the root folder.
@Pattern.List(@Pattern(regexp = "^[A-Za-z]*$", message = "{invalid.alphabetic}"))
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
public @interface Alphabetic {
	//Default items that needs to be added to the annotation
	String message() default "{invalid.alphabetic}";	
	Class<?>[] groups() default {};	
	Class<? extends Payload>[] payload() default {};
}
