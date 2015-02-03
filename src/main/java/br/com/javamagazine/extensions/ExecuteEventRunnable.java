package br.com.javamagazine.extensions;

import javax.enterprise.inject.spi.ObserverMethod;

public class ExecuteEventRunnable implements Runnable {
	
	private ObserverMethod delegate;
	
	private Object event;
	
	public ExecuteEventRunnable(ObserverMethod delegate, Object event) {
		this.delegate = delegate;
		this.event = event;
	}
	
	@Override
	public void run() {
		delegate.notify(event);
	}

}
