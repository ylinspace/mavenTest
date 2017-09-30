/**
 * 
 */
package org.cute.spring.factory;

import org.springframework.beans.factory.FactoryBean;
import org.cute.cache.CacheProxy;

/**
 * Cache工厂，封装缓存，作为缓存统一出口，底层可切换缓存平台
 * @author yang
 *
 */
public class CacheFactory implements FactoryBean<CacheProxy>{
	
	/**
	 * 缓存对象
	 */
	private CacheProxy cacheProxy = null;
	
	/**
	 * 传入缓存对象实例
	 * @param cacheProxy
	 */
	public CacheFactory(CacheProxy cacheProxy){
		this.cacheProxy = cacheProxy;
	}

	public CacheProxy getObject() throws Exception {
		return cacheProxy;
	}

	public Class<?> getObjectType() {
		return CacheProxy.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
