package br.com.javamagazine.extension;

public interface ExpressionInterpreter<E, R> {

	public R interpret(E expression);

}
