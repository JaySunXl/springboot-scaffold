package com.jaysunxl.scaffold.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author sunxind
 * @date 2022-10-25
 */
public class JedisUtils {
    private static final JedisPool JEDIS_POOL;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);
        config.setMaxIdle(8);
        config.setMinIdle(0);
        config.setMaxWaitMillis(200);
        JEDIS_POOL = new JedisPool(config, "192.168.25.139", 6379,1000);
    }

    /**
     * 从连接池中获取jedis连接
     *
     * @return
     */
    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }
}
