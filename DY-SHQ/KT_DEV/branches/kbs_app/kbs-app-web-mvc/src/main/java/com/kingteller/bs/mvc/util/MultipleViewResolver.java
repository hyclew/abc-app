package com.kingteller.bs.mvc.util;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MultipleViewResolver implements ViewResolver {
	private Map<String, ViewResolver> resolvers;

    public void setResolvers(Map<String, ViewResolver> resolvers) {

        this.resolvers = resolvers;
    }

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		ViewResolver resolver = null;
		if(viewName.lastIndexOf("500") != -1){
			resolver = resolvers.get("jsp");
		} else {
			resolver = resolvers.get("html");
		}
		return resolver.resolveViewName(viewName, locale);
	}
}
