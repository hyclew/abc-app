package org.kbs.app.web.security.sample.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserRepositoryCustom{
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
