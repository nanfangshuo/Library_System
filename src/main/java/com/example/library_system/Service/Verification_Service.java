package com.example.library_system.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class Verification_Service {
    @Autowired
    private StringRedisTemplate redisTemplate;

    //key为Id，value为生成的验证码
    public String generateAndSaveCode(String key) {
        String code = String.format("%06d", new Random().nextInt(999999));
        redisTemplate.opsForValue().set(key, code, 3, TimeUnit.MINUTES);
        return code;
    }

    public String getCode(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}