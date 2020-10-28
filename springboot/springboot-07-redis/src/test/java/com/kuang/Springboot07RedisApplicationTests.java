package com.kuang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import com.kuang.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot07RedisApplicationTests {

    @Autowired//使用默认配置好的模板bean
    private RedisTemplate redisTemplate;

//    @Autowired
//    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        //opsFor...操作...(某一个数据类型）
        //        redisTemplate.opsForValue().append();
        //除了基本操作，常用方法也可以直接使用，比如事务和基本的CRUD
//        redisTemplate.execute();
        //也可以获取连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushAll();
//        connection.flushDb();

        //一般不使用这种原生方式去写代码，一般集成到一个工具类RedisUtils中
//        redisUtil.*******();
        redisTemplate.opsForValue().set("myKey","姜123abc");
        System.out.println(redisTemplate.opsForValue().get("myKey"));


    }

    @Test
    public void test() throws JsonProcessingException {
        User user = new User("姜", 18);
        String jsonuser = new ObjectMapper().writeValueAsString(user);//将对象序列化为json对象, redis要求对象可以进行序列化
        //给对象实现serializable接口也可以
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
