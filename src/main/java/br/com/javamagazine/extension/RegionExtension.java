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
        
        // verifica se o bean sendo analisado possui a anotação @IncludeRegion
        if (isIncludeAnnotationPresent) {
            IncludeRegion annotation = annotatedType.getAnnotation(IncludeRegion.class);
            Region expression = annotation.onExpression();
            
            // interpreta a expressao definida como metadados na anotação @IncludeRegion
            RegionExpressionInterpreter interpreter = new RegionExpressionInterpreter();
            boolean expressionInterpreted = interpreter.interpret(expression);
            
            // caso a expressão seja interpretada como inválida o bean passa a ser @Vetoed
            // dessa forma o bean não é adicionado no contexto 
            // CDI e não fica disponivel para injeção
            if (!expressionInterpreted) {
                pat.veto();
            }
        }
    }
    
}
