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
            Region region = annotation.value();
            
            // validador da região indicada na anotação @IncludeRegion
            RegionValidator validator = new RegionValidator();
            
            // caso a região do bean sendo analisado não for suportada o mesmo 
            // deve ser @Vetoed. Assim o bean não é adicionado no contexto 
            // CDI e não fica disponivel para injeção
            if (validator.unsupported(region)) {
                pat.veto();
            }
        }
    }
    
}
