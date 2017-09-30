package org.cute;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest implements Filter{

	private FilterConfig config ;
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		config = null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		config.getServletContext();
		
		System.out.println("执行之前");
		chain.doFilter(arg0, arg1);
		System.out.println("执行之后");
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
	}

}
