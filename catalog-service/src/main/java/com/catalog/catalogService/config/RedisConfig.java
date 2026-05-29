package com.catalog.catalogService.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisConfig {

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);

    // Use String serialization for keys so they are readable in Redis CLI

    //    template.setKeySerializer(new StringRedisSerializer());
    //    template.setHashKeySerializer(new StringRedisSerializer());

    // We let Spring use its default serializer (JdkSerializationRedisSerializer) for values.
    // It just works automatically without any Jackson version conflicts.

    return template;
  }

  @Bean
  public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    return RedisCacheManager.create(connectionFactory);
  }
}
