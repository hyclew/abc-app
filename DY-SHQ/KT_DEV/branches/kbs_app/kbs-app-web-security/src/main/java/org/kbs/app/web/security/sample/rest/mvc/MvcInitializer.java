package org.kbs.app.web.security.sample.rest.mvc;

import org.kbs.app.web.security.sample.rest.HttpSessionConfig;
import org.kbs.app.web.security.sample.rest.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// tag::config[]
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SecurityConfig.class, HttpSessionConfig.class};
	}
	// end::config[]

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
