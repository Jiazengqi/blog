package com.example.blog.util;

import redis.clients.jedis.Jedis;

public final class RedisUtil {
    private static Jedis jd = new Jedis("127.0.0.1");

    private RedisUtil(){}

    /**
     * 设置值
     * @param key
     * @param obj
     */
    public static void set(String key,Object obj)
    {

        jd.set(key.getBytes(), SerializeUtil.toSerialize(obj));
    }

    /**
     * 得到值
     * @param key
     * @return
     */
    public static Object get(String key)
    {
        byte[] bs =jd.get(key.getBytes());
        return SerializeUtil.serializeToObj(bs);
    }
    /**
     * 设置一个带失效时间的值
     * @param key 键
     * @param obj 存储的对象
     * @param time 有效期
     */
    public static void set(String key,Object obj,int time)
    {
        jd.setex(key.getBytes(), time, SerializeUtil.toSerialize(obj));
    }

    /**
     * 设置session
     * @param key
     * @param obj
     */
    public static void setSession(String key,Object obj){
        set(key,obj,60*30);
    }

    /**
     * 判断该数据是否存在
     * @param key
     * @return
     */
    public static boolean isHas(String key){

        return jd.exists(key.getBytes());
    }

    /**
     * 删除指定的key的值
     * @param key
     */
    public static void del(String key){
        jd.del(key.getBytes());
    }

    /**
     * 清空所有数据
     */
    public static void flushDB(){
        jd.flushDB();
    }

}
