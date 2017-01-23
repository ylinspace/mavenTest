package org.yl;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class ListenerResultTest implements PreResultListener{

	public void beforeResult(ActionInvocation invocation, String result) {
		if(result.equals(Action.SUCCESS)){
		}
		System.out.println("【拦截器监听器】监听到处理结果为"+result);
		invocation.getInvocationContext().put("excuteTime", new Date());
	}
	
}
