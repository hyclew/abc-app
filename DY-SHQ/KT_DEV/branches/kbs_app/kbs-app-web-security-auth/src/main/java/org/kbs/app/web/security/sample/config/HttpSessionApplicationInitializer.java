package org.kbs.app.web.security.sample.config;
import org.springframework.core.annotation.Order;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Order(99)
public class HttpSessionApplicationInitializer extends AbstractHttpSessionApplicationInitializer {
}
