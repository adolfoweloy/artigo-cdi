package br.com.javamagazine.extensions;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.ObserverMethod;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ObserverMethodWrapper<T> implements ObserverMethod<T> {

	private ObserverMethod<T> delegate;
	
	private ExecutorService executor;
	
	private ExecutorService getExecutor() {
		if (executor != null) {
			return executor;
		}
		
		try {
			Context ctx = new InitialContext();
			executor = (ExecutorService) ctx.lookup("java:comp/env/concurrent/ManagedExecutorService");
			
		} catch (NamingException e) {
			executor = Executors.newCachedThreadPool();
		}
		
		return executor;
	}
	
	public ObserverMethodWrapper(ObserverMethod<T> wrapped) {
		this.delegate = wrapped;
	}

	@Override
	public Class getBeanClass() {
		return delegate.getBeanClass();
	}

	@Override
	public Type getObservedType() {
		return delegate.getObservedType();
	}

	@Override
	public Set getObservedQualifiers() {
		return delegate.getObservedQualifiers();
	}

	@Override
	public Reception getReception() {
		return delegate.getReception();
	}

	@Override
	public TransactionPhase getTransactionPhase() {
		return delegate.getTransactionPhase();
	}

	@Override
	public void notify(T event) {
		delegate.notify(event);
	}

}
