package br.com.javamagazine.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

public class ControllerPorConvencao implements Extension {

	public void configuraControllers(@Observes ProcessAnnotatedType<?> pat) {
		AnnotatedType<?> at = pat.getAnnotatedType();
		
		Class<?> injectedClass = at.getJavaClass();
		String packageName = injectedClass.getPackage().getName();
		String className = injectedClass.getSimpleName();
		
		if (packageName.endsWith("controllers") || className.endsWith("Controller")) {
			pat.setAnnotatedType(new AnnotatedTypeControllerWrapper(at));
			System.out.println("encontrado o controller:" + className);
		}
		
	}
	
}
