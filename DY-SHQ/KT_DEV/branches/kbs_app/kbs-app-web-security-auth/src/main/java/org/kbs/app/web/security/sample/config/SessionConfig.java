package org.kbs.app.web.security.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.redis.embedded.EnableEmbeddedRedis;

@Configuration
@EnableRedisHttpSession
//@EnableEmbeddedRedis
public class SessionConfig {
	@Bean
	public JedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}
}
