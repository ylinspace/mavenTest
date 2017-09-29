/**
 * 
 */
package org.ce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author yang
 *
 */
@Aspect
public class BeforeAdviceTest {
	
	@Pointcut("execution(public * org.ce.service.*Impl.*(..))")
	public void myPointcut(){};

	@Before("myPointcut()")
	public void authority(){
		System.out.println("模拟执行权限检查！");
	}
	
	@AfterReturning(pointcut="myPointcut()",returning="rvt")
	public void log(Object rvt){
		System.out.println("获取目标方法返回值："+rvt);
	}
	
	@After("myPointcut()")
	public void release(){
		System.out.println("模拟方法结束后的释放资源！");
	}
	
	@Around("myPointcut()")
	public Object processTx(ProceedingJoinPoint jp) throws java.lang.Throwable{
//		System.out.println("执行目标方法前，模拟开始事务。。。");
//		User user = new User();
//		user.setPassword("root");
//		user.setUsername("root");
//		Object rvt = jp.proceed(new Object[]{user});
//		System.out.println("执行目标方法之后，模拟事务结束！");
		return jp.proceed();
	}
}
