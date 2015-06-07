package org.kbs.app.web.security.sample.session;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

// tag::class[]
public class Initializer
		extends AbstractHttpSessionApplicationInitializer { // <1>

	public Initializer() {
		super(Config.class); // <2>
	}
}
// end::class[]