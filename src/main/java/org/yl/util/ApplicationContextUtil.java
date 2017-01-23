/**
 * 
 */
package org.yl.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContext实例工具类，部署到Spring中即可使用
 * @author yang
 *
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext(){
		return ApplicationContextUtil.applicationContext;
	}
	
}
