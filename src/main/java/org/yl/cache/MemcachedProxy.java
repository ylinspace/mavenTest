///**
// *
// */
//package org.yl.cache;
//
//import java.util.Date;
//
//import com.danga.MemCached.MemCachedClient;
//
///**
// * memcached代理对象类
// * @author yang
// *
// */
//public class MemcachedProxy implements CacheProxy{
//
//	/**
//	 * memcached实例对象
//	 */
//	private MemCachedClient client = null;
//
//	/**
//	 * 实例化memcached对象
//	 * @param poolName
//	 */
//	public MemcachedProxy(String poolName){
//		synchronized (MemcachedProxy.class) {
//			if(client == null){
//				client = new MemCachedClient(poolName);
//			}
//		}
//	}
//
//	public void put(String key, Object Value) {
//		client.add(key, Value);
//	}
//
//	public void put(String key, Object value, Integer expiredSecond) {
//		Long time = System.currentTimeMillis() + expiredSecond * 60 * 1000L ;
//		client.add(key, value, new Date(time));
//	}
//
//	public Object get(String key) {
//		return client.get(key);
//	}
//
//
//
//
//}
