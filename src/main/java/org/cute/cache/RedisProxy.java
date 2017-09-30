/**
 * 
 */
package org.cute.cache;

import redis.clients.jedis.Jedis;

/**
 * Redis代理类
 * @author yang
 *
 */
public class RedisProxy extends RedisSupport implements CacheProxy {
	
	public void put(String key, Object value) {
		this.put(key, value, Integer.parseInt(super.expireSecond));
	}

	public void put(String key, Object value, Integer expiredSecond) {
		Jedis jedis = null;
		try{
			jedis = this.getJedis();
			jedis.setex(key.getBytes(),expiredSecond, serialize(value));
		}catch(Exception e){
			e.printStackTrace();
			jedispool.returnBrokenResource(jedis);
		}finally{
			jedispool.returnResource(jedis);
		}
	}

	public Object get(String key) {
		Jedis jedis = null;
		Object obj = null;
		try{
			jedis = this.getJedis();
			obj = unserialize(jedis.get(key.getBytes()));
		}catch(Exception e){
			e.printStackTrace();
			jedispool.returnBrokenResource(jedis);
		}finally{
			jedispool.returnResource(jedis);
		}
		return obj;
	}


}
