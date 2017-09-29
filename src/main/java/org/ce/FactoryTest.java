/**
 * 
 */
package org.ce;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author yang
 *
 */
public class FactoryTest implements ApplicationContextAware{

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public ApplicationContext getApplicationContext(){
		return this.applicationContext;
	}
}
