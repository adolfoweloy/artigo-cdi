package br.com.javamagazine.extension;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.javamagazine.region.Region;

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE})
public @interface IncludeRegion {

	Region onExpression();

	Class<? extends RegionExpressionInterpreter> interpretedBy();

}
