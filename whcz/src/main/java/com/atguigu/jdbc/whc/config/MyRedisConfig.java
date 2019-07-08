package com.atguigu.jdbc.whc.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class MyRedisConfig {
//    @Bean
//    @ConditionalOnMissingBean(name = "redisTemplate")
//    public RedisTemplate<Object, Employee> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Employee> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Employee.class);
//        template.setDefaultSerializer(jackson2JsonRedisSerializer);
//        return template;
//    }
//    @Bean
//    public RedisCacheManager employeeManager(RedisTemplate<Object, Employee> redisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setUsePrefix(true);
//        return cacheManager;
//    }

}
