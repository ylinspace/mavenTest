/**
 * 
 */
package org.yl.util;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author yang
 *
 */
public class JedisClientUtil {
	protected static JedisPool jedispool;  
    protected static int EXPIRE = 130;  
    static{  
        JedisPoolConfig jedisconfig = new JedisPoolConfig();  
        jedisconfig.setMaxActive(512);  
        jedisconfig.setMaxIdle(100);  
        jedisconfig.setMaxWait(100000);  
        jedisconfig.setTestOnBorrow(true);  
        jedisconfig.setTestOnReturn(true);  
        jedispool = new JedisPool(jedisconfig,"127.0.0.1", 6379, 100000);  
    }  
	
	public static void main(String [] args){
		Jedis jedis = jedispool.getResource();
		jedis.set("a", "111");
		String aaa = jedis.get("a");
		System.out.println(aaa);
	}
	
}
