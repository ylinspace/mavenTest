package org.yl;

import org.yl.action.LoginAction;
import org.yl.vo.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorTest extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String interceptorName;

	public void setInterceptorName(String name) {
		this.interceptorName = name;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("【拦截器】执行前,Interceport名字为：" + interceptorName);

		Object obj = invocation.getAction();
		// 登录Action
		if (obj.getClass().getName().equals(LoginAction.class.getName())) {
			System.out.println("【拦截器】执行LoginAtion");
			LoginAction action = (LoginAction) obj;
			User user = action.getUser();
			if (user.getUsername() != null) {
				System.out.println("【拦截器】当前尝试登录的账号为：" + user.getUsername());
			}
		}

		// Action结果监听器
		invocation.addPreResultListener(new ListenerResultTest());
		// 执行Action
		String result = invocation.invoke();

		System.out.println("【拦截器】执行后" + invocation.getAction().getClass().toString() + "返回结果为：" + result);
		return result;
	}

}
