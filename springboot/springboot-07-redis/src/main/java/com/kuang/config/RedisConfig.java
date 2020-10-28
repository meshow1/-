package com.kuang.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean//用自己写的模板代替默认的，配置具体的序列化方式，默认为JDK序列化
    //JDK序列化在shell窗口周会显示乱码
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        //Json配置序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);


        //指定序列化输入类型，使其json序列变成类型的序列，而不是单纯的键值对，意思是说使这个json序列属于某个类，在
        // json中将类名一起保存下来， 已经过期被替代
        //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance ,ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(om);
        //String的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        //key采用String序列化方式
        template.setKeySerializer(stringRedisSerializer);
        //hash的key采用String序列化
        template.setHashKeySerializer(stringRedisSerializer);
        //value采用json
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的value采用json
        template.setHashKeySerializer(jackson2JsonRedisSerializer);

        //去对所有属性进行配置（设置了的就使用配置好的，没配置就使用默认的）
        template.afterPropertiesSet();

        return template;
    }
}
