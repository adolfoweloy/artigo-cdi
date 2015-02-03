package br.com.javamagazine.extensions;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD})
@RequestScoped @Named
public @interface Controller {
}
