/**
 * 
 */
package org.cute.cache;

/**
 * 缓存代理接口
 * 用于夸多个缓存平台统一接口
 * @author yang
 *
 */
public interface CacheProxy {

	/**
	 * 放入对象到缓存中
	 * @param key
	 * @param Value
	 */
	public void put(String key,Object Value);
	
	/**
	 * 放入对象到缓存中，并设置过期时间
	 * @param key
	 * @param value
	 * @param expiredSecond 秒钟
	 */
	public void put(String key,Object value,Integer expiredSecond);
	
	/**
	 * 获取缓存的对象
	 * @param key
	 * @return
	 */
	public Object get(String key);
	
}
