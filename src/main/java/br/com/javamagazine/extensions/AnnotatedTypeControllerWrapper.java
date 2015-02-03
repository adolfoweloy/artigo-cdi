package br.com.javamagazine.extensions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedConstructor;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.util.AnnotationLiteral;

public class AnnotatedTypeControllerWrapper<X> implements AnnotatedType<X> {

	private AnnotatedType<X> wrapped;

	public AnnotatedTypeControllerWrapper(AnnotatedType<X> wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public Type getBaseType() {
		return wrapped.getBaseType();
	}

	@Override
	public Set<Type> getTypeClosure() {
		return wrapped.getTypeClosure();
	}

	@Override
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		return wrapped.getAnnotation(annotationType);
	}

	@Override
	public Set<Annotation> getAnnotations() {
		
		Set<Annotation> annotations = new HashSet<>(wrapped.getAnnotations());
		annotations.add(new AnnotationLiteral<Controller>() {});
		return annotations;
		
	}

	@Override
	public boolean isAnnotationPresent(
			Class<? extends Annotation> annotationType) {
		return wrapped.isAnnotationPresent(annotationType);
	}

	@Override
	public Class<X> getJavaClass() {
		return wrapped.getJavaClass();
	}

	@Override
	public Set<AnnotatedConstructor<X>> getConstructors() {
		return wrapped.getConstructors();
	}

	@Override
	public Set<AnnotatedMethod<? super X>> getMethods() {
		return wrapped.getMethods();
	}

	@Override
	public Set<AnnotatedField<? super X>> getFields() {
		return wrapped.getFields();
	}

}
