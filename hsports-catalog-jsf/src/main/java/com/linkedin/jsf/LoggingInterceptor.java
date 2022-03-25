package com.linkedin.jsf;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@ILoggingInterceptor
@Interceptor
public class LoggingInterceptor {

	public LoggingInterceptor() {
		// TODO Auto-generated constructor stub
	}
	//This AroundInvoke annotation is the one being triggered and intercepted.
	//ic refers to the actual method being invoked
	//ic.proceed() is important. It allows the process to continue.
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		System.out.println("Method invoked is " + ic.getMethod().getName());
		return ic.proceed();
	}

}
