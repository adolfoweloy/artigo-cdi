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
            Region region = annotation.value();
            
            // validador da regi�o indicada na anota��o @IncludeRegion
            RegionValidator validator = new RegionValidator();
            
            // caso a regi�o do bean sendo analisado n�o for suportada o mesmo 
            // deve ser @Vetoed. Assim o bean n�o � adicionado no contexto 
            // CDI e n�o fica disponivel para inje��o
            if (validator.unsupported(region)) {
                pat.veto();
            }
        }
    }
    
}
