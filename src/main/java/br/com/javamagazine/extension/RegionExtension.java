package br.com.javamagazine.extension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import br.com.javamagazine.region.Region;

public class RegionExtension implements Extension {
  
  @SuppressWarnings("rawtypes")
  public void loadClassesToBeIncludedByCDI(@Observes ProcessAnnotatedType pat) {
      AnnotatedType at = pat.getAnnotatedType();

      boolean isIncludeAnnotationPresent = at.isAnnotationPresent(IncludeRegion.class);

      // verifica se o bean sendo analisado possui a anota��o @Include
      if (isIncludeAnnotationPresent) {
          IncludeRegion annotation = at.getAnnotation(IncludeRegion.class);
          Region expression = annotation.onExpression();

          // interpreta a express�o definida como metadados da anota��o @Include
          RegionExpressionInterpreter interpreter = new RegionExpressionInterpreter();
          Boolean expressionInterpreted = interpreter.interpret(expression);
          
          // caso a express�o seja interpretada como inv�lida, o bean � Vetoed 
          // ou seja, n�o fica habilitado para inje��o.
          if (!expressionInterpreted) {
              pat.veto();
          }
      }
  }

}
