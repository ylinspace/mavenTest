package org.ce;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class InterceptorMethodTest extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1865694030623088306L;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("方法拦截器："+arg0.getAction());
		return arg0.invoke();
	}

}
