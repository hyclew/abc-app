package org.kbs.app.web.security.sample.session;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.redis.embedded.EnableEmbeddedRedis;
//import org.springframework.session.redis.embedded.RedisServerPort;

// tag::class[]
//@EnableEmbeddedRedis // <1>
//@EnableRedisHttpSession // <2>
public class Config {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connection = new JedisConnectionFactory(); // <3>
		//connection.setPort(port);
		return connection;
	}
}
// end::class[]