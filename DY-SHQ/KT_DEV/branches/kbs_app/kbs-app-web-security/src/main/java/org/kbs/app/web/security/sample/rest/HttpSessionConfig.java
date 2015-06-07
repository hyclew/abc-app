package org.kbs.app.web.security.sample.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.redis.embedded.EnableEmbeddedRedis;
//import org.springframework.session.redis.embedded.RedisServerPort;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

// tag::class[]
//@Configuration
//@EnableEmbeddedRedis // <1>
//@EnableRedisHttpSession // <2>
public class HttpSessionConfig {

//	@Bean
//	public JedisConnectionFactory connectionFactory(@RedisServerPort int port) {
//		JedisConnectionFactory factory = new JedisConnectionFactory();  // <3>
//		factory.setPort(port);
//		return factory;
//	}

	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy(); // <4>
	}
}
// end::class[]