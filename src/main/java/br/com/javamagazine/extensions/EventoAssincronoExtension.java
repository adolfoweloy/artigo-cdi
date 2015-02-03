package br.com.javamagazine.extensions;

import java.lang.reflect.Method;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ObserverMethod;

import org.jboss.weld.bean.builtin.BeanManagerProxy;
import org.jboss.weld.event.ObserverMethodImpl;
import org.jboss.weld.injection.MethodInjectionPoint;
import org.jboss.weld.manager.BeanManagerImpl;

public class EventoAssincronoExtension implements Extension {

	public void afterBeanDiscovery(@Observes AfterBeanDiscovery event, 
		BeanManager bm) {
		
		BeanManagerImpl manager = ((BeanManagerProxy)bm).delegate();
		List<ObserverMethod<?>> observers = manager.getObservers();
		
		for (ObserverMethod<?> observerMethod : observers) {
			ObserverMethodImpl observerMethodImpl = (ObserverMethodImpl) observerMethod;
			MethodInjectionPoint injectionPoint = observerMethodImpl.getMethod();
			AnnotatedMethod annotated = injectionPoint.getAnnotated();
			Method javaMember = annotated.getJavaMember();
			if (javaMember.isAnnotationPresent(Assincrono.class)) {
				
				ObserverMethod original = observerMethodImpl;
				ObserverMethod wrapper = new ObserverMethodWrapper(original);
				observers.remove(original);
				observers.add(wrapper);
				
			}
		}
		System.out.println("todos os beans já foram lidos");
	}
}
