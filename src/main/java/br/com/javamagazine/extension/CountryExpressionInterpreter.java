package br.com.javamagazine.extension;

public class CountryExpressionInterpreter implements ExpressionInterpreter<String, Boolean> {

	@Override
	public Boolean interpret(String expression) {
		String fromConfig = "AR";
		return fromConfig.equals(expression);
	}

}
