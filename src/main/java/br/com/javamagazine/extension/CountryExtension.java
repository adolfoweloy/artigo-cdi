package br.com.javamagazine.extension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

public class CountryExtension implements Extension {

	@SuppressWarnings("rawtypes")
	public void loadClassesToBeIncludedByCDI(@Observes ProcessAnnotatedType pat) {
		AnnotatedType at = pat.getAnnotatedType();

		boolean isIncludeAnnotationPresent = at.isAnnotationPresent(Include.class);

		if (isIncludeAnnotationPresent) {
			Include annotation = at.getAnnotation(Include.class);
			String expression = annotation.onExpression();

			CountryExpressionInterpreter interpreter = new CountryExpressionInterpreter();
			Boolean expressionInterpreted = interpreter.interpret(expression);
			if (!expressionInterpreted) {
				pat.veto();
			}
		}
	}

}
