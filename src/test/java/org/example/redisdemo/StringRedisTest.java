package org.example.redisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.redisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class StringRedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    //序列化JSON工具
    private static final ObjectMapper mapper = new ObjectMapper();
    @Test
    void testString() throws JsonProcessingException {
        //准备对象
        User user = new User("虎哥",22);
        //手动序列化
        String json = mapper.writeValueAsString(user);
        //写入
        stringRedisTemplate.opsForValue().set("user1111",json);
        //读取数据
        String rJson = stringRedisTemplate.opsForValue().get("user1111");
        //反序列化
        User user1 = mapper.readValue(rJson,User.class);
        System.out.println(user1);
    }
}

