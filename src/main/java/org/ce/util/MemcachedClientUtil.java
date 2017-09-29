///**
// *
// */
//package org.ce.util;
//
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//import com.schooner.MemCached.SchoonerSockIOPool;
//
///**
// * @author yang
// *
// */
//public class MemcachedClientUtil {
//
//	private static MemCachedClient cacheClient = new MemCachedClient();
//
//	static {
//		// 设置缓存服务器列表，当使用分布式缓存的时，可以指定多个缓存服务器。这里应该设置为多个不同的服务，我这里将两个服务设置为一样的，大家不要向我学习，呵呵。
////		String[] servers = { "127.0.0.1:11211" };
////
////		// 设置服务器权重
////		// Integer[] weights = { 3, 2 };
////
////		// 创建一个Socked连接池实例
////		SockIOPool pool = SockIOPool.getInstance();
////
////		// 向连接池设置服务器和权重
////		pool.setServers(servers);
////		// pool.setWeights(weights);
////
////		// set some TCP settings
////		// disable nagle
////		// set the read timeout to 3 secs
////		// and don't set a connect timeout
////		pool.setNagle(false);
////		pool.setSocketTO(3000);
////		pool.setSocketConnectTO(0);
////
////		// initialize the connection pool
////		pool.initialize();
//	}
//
//	/**
//	 * @return the cacheClient
//	 */
//	public static MemCachedClient getCacheClient() {
//		return cacheClient;
//	}
//
//	/**
//	 * @param cacheClient the cacheClient to set
//	 */
//	public static void setCacheClient(MemCachedClient cacheClient) {
//		MemcachedClientUtil.cacheClient = cacheClient;
//	}
//
//	public static void main(String[] args) {
//		MemCachedClient mcc = new MemCachedClient();
//
//		System.out.println(SchoonerSockIOPool.getInstance());
//
//		System.out.println(mcc.add("aa", "11"));
////		for (int i = 0; i < 100; i++) {
////			try {
////				boolean aaa = mcc.add("aaq" + i, Integer.valueOf(new Random().nextInt(100)), 12);
////				mcc.get(paramString, paramInteger)
////				mcc.add("aa", "aaa", new Date(new Date().getTime() + 10 * 60 * 1000) );
//
//		System.out.println(mcc.get("aa"));
////				System.out.println(aaa);
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
////		}
//	}
//
//
//
//}
