package org.kbs.app.web.security.sample.boot.config;

import org.springframework.session.data.redis.config.annotation.web.http.*;
//import org.springframework.session.redis.embedded.EnableEmbeddedRedis;


//@EnableEmbeddedRedis
// tag::class[]
@EnableRedisHttpSession // <1>
public class HttpSessionConfig { }
// end::class[]