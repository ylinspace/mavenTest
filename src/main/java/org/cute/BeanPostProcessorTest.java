/**
 * 
 */
package org.cute;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author yang
 *
 */
public class BeanPostProcessorTest implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean后处理器在初始化前对【"+beanName+"】进行增强处理。。。");
		return null;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean后处理器在初始化后对【"+beanName+"】进行增强处理。。。");
		return null;
	}

}
