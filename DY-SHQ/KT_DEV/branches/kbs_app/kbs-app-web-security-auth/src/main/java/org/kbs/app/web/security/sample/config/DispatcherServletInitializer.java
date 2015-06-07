package org.kbs.app.web.security.sample.config;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.setAsyncSupported(true);
		encodingFilter.addMappingForUrlPatterns(null, true, "/*");
		servletContext.addListener(new HttpSessionEventPublisher());
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {AppConfig.class,SessionConfig.class,SecurityConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfig.class,MethodSecurityConfig.class};
	}
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
