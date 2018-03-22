package com.lusifer.leeshop.service.redis.api;

public interface RedisService {
    public Object get(String key);

    public void set(String key, Object val);

    public void set(String key, Object val, int seconds);
}
