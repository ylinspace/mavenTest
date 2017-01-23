/**
 * 
 */
package org.yl.cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author yang
 *
 */
public class RedisSupport {

	/**
	 * 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；如果赋值为-1，则表示不限制
	 */
	private String maxActive;

	/**
	 * 控制一个pool最多有多少个状态为idle的jedis实例
	 */
	private String maxIdle;

	/**
	 * 表示当borrow一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
	 */
	private String maxWait;

	/**
	 * 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
	 */
	private String testOnBorrow;

	/**
	 * 在return给pool时，是否提前进行validate操作；
	 */
	private String testOnReturn;

	/**
	 * 缓存过期时间
	 */
	protected String expireSecond;

	/**
	 * 服务器IP
	 */
	private String ip;

	/**
	 * 服务器端口
	 */
	private String port;
	
	/**
	 * timeout
	 */
	private String timeout;
	
	/**
	 * jedispool实例
	 */
	protected static JedisPool jedispool;
	
	/**
	 * 初始化
	 */
	public void initialize(){
		try{
			JedisPoolConfig jedisconfig = new JedisPoolConfig();
			jedisconfig.setMaxActive(Integer.parseInt(maxActive));
			jedisconfig.setMaxIdle(Integer.parseInt(maxIdle));
			jedisconfig.setMaxWait(Long.parseLong(maxWait));
			jedisconfig.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
			jedisconfig.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
			jedispool = new JedisPool(jedisconfig, ip, Integer.parseInt(port), Integer.parseInt(timeout));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 获取jedis实例对象
	 * @return
	 */
	protected Jedis getJedis() {
		Jedis jedis = null;
		try {
			jedis = jedispool.getResource();
		} catch (JedisConnectionException jce) {
			jce.printStackTrace();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jedis = jedispool.getResource();
		}
		return jedis;
	}
	
	/**
	 * 将对象序列化为字节数组
	 * @param obj
	 * @return
	 */
	protected byte[] serialize(Object obj){
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			return bos.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 反序列化对象
	 * @param bytes
	 * @return
	 */
	protected Object unserialize(byte[] bytes){
		try{
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			return ois.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param maxActive the maxActive to set
	 */
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	/**
	 * @param maxIdle the maxIdle to set
	 */
	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}

	/**
	 * @param maxWait the maxWait to set
	 */
	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}

	/**
	 * @param testOnBorrow the testOnBorrow to set
	 */
	public void setTestOnBorrow(String testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	/**
	 * @param testOnReturn the testOnReturn to set
	 */
	public void setTestOnReturn(String testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	/**
	 * @param expireSecond the expireSecond to set
	 */
	public void setExpireSecond(String expireSecond) {
		this.expireSecond = expireSecond;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	/**
	 * @param jedispool the jedispool to set
	 */
	public static void setJedispool(JedisPool jedispool) {
		RedisSupport.jedispool = jedispool;
	}
}
