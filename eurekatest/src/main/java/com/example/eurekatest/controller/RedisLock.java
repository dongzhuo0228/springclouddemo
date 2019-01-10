/*
package com.example.eurekatest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.Collections;

*/
/**
 * @ClassName: RedisLock
 * @Description: Redis的分布式锁，用来控制定时任务
 *//*

@Service
public class RedisLock {

	private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);
	*/
/**
	 * 加锁成功标志位
	 *//*

	private static final String LOCK_SUCCESS = "OK";
	*/
/**
	 * 标记为setnx方式
	 *//*

	private static final String SET_IF_NOT_EXIST = "NX";
	*/
/**
	 * 增加超时时间标志
	 *//*

	private static final String SET_WITH_EXPIRE_TIME = "PX";
	*/
/**
	 * 解锁成功标志
	 *//*

	private static final Long RELEASE_SUCCESS = 1L;

	*/
/**
	 * 超时时间60s
	 *//*

	private static final Integer EXPIRETIME = 60000;

	@Autowired
	private JedisPool jedisPool;

	private Jedis jedis;

	@PostConstruct
	public void init(){
		jedis = jedisPool.getResource();
	}


	*/
/** 注入jedis 连接池对象 *//*

	*/
/**
	 * 
	 * @MethodName lock
	 * @Description 获取分布式锁
	 * @param key
	 *            锁
	 * @param requestId
	 *            请求标识
	 * @return
	 *//*

	public boolean lock(String key, String requestId) {
		if (LOCK_SUCCESS.equals(jedis.set(key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, EXPIRETIME))) {
			logger.info("加锁成功key = " + key);
			return true;
		}
		logger.info("加锁失败key = " + key);
		return false;
	}

	*/
/**
	 * 
	 * @MethodName releaseDistributedLock
	 * @Description 解锁，确定原子性使用lua脚本
	 *            锁
	 * @param requestId
	 *            请求标识
	 *            Redis客户端
	 * @return
	 *//*

	public boolean releaseDistributedLock(String lockKey, String requestId) {
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
		if (RELEASE_SUCCESS.equals(result)) {
			logger.info("解锁成功lockKey = " + lockKey);
			return true;
		}
		logger.info("解锁失败lockKey = " + lockKey);
		return false;

	}

}
*/
