package org.example.redisdemo;

import org.example.redisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name","虎哥");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);

    }

    @Test
    void testSaveUser(){
        redisTemplate.opsForValue().set("user11",new User("虎哥",22));
        User user = (User)redisTemplate.opsForValue().get("user11");
        System.out.println(user);
    }

}
