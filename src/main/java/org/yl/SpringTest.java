/**
 * 
 */
package org.yl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 *
 */
public class SpringTest {

	public static void main(String [] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		FactoryTest test = (FactoryTest)ctx.getBean("factoryTest");
		
		System.out.println(ctx == test.getApplicationContext());
	}
	
}
