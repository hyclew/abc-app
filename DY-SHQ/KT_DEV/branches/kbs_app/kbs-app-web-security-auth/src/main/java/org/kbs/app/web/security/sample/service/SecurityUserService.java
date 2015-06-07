package org.kbs.app.web.security.sample.service;
import org.kbs.app.web.security.sample.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SecurityUserService {
	@PreAuthorize("hasAuthority('USER_QUERY')")
	Page<User> findAll(Pageable pageable);
	User save(User user);
	User findOne(Long id);
	void delete(Long id);
}
