package com.qf;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @version 1.0
 * @user zhangliang
 * @date 2019/7/15 17:16
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Java操作redis
         */
        //配置redis的连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(100);
        config.setMaxTotal(200);
        config.setMinIdle(50);

        JedisPool jedisPool = new JedisPool(config,"192.168.159.188",6379,1000,"root");

        //1.连接redis
//        Jedis jedis = new Jedis("192.168.159.188",6379);
        Jedis jedis = jedisPool.getResource();
        //认证密码
        jedis.auth("root");

        //2.操作redis
        jedis.set("money","20000");

        //3.关闭连接
        jedis.close();
    }
}
