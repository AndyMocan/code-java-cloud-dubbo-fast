package com.lusifer.leeshop.service.redis.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lusifer.leeshop.service.redis.api.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object val) {
        redisTemplate.opsForValue().set(key, val);
    }

    @Override
    public void set(String key, Object val, int seconds) {
        redisTemplate.opsForValue().set(key, val, seconds, TimeUnit.SECONDS);
    }
}
