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

      // verifica se o bean sendo analisado possui a anotação @Include
      if (isIncludeAnnotationPresent) {
          IncludeRegion annotation = at.getAnnotation(IncludeRegion.class);
          Region expression = annotation.onExpression();

          // interpreta a expressão definida como metadados da anotação @Include
          RegionExpressionInterpreter interpreter = new RegionExpressionInterpreter();
          Boolean expressionInterpreted = interpreter.interpret(expression);
          
          // caso a expressão seja interpretada como inválida, o bean é Vetoed 
          // ou seja, não fica habilitado para injeção.
          if (!expressionInterpreted) {
              pat.veto();
          }
      }
  }

}
