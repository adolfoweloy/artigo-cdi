package br.com.javamagazine.extension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import br.com.javamagazine.region.Region;

public class RegionExtension implements Extension {

    public void loadClassesToBeIncludedByCDI(@Observes ProcessAnnotatedType<?> pat) {
        AnnotatedType<?> annotatedType = pat.getAnnotatedType();
        
        boolean isIncludeAnnotationPresent = annotatedType.isAnnotationPresent(IncludeRegion.class);
        
        // verifica se o bean sendo analisado possui a anota��o @IncludeRegion
        if (isIncludeAnnotationPresent) {
            IncludeRegion annotation = annotatedType.getAnnotation(IncludeRegion.class);
            Region expression = annotation.onExpression();
            
            // interpreta a expressao definida como metadados na anota��o @IncludeRegion
            RegionExpressionInterpreter interpreter = new RegionExpressionInterpreter();
            boolean expressionInterpreted = interpreter.interpret(expression);
            
            // caso a express�o seja interpretada como inv�lida o bean passa a ser @Vetoed
            // dessa forma o bean n�o � adicionado no contexto 
            // CDI e n�o fica disponivel para inje��o
            if (!expressionInterpreted) {
                pat.veto();
            }
        }
    }
    
}
