package br.com.javamagazine.extension;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE})
@Qualifier
public @interface Include {

	String onExpression();

	Class<? extends CountryExpressionInterpreter> interpretedBy();

}
