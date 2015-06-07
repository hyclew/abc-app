package org.kbs.app.web.security.sample.config;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import javax.servlet.ServletContext;

@Order(100)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
	}
}
