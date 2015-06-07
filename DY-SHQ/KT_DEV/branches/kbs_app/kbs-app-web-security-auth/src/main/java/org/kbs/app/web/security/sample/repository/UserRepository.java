package org.kbs.app.web.security.sample.repository;

import org.kbs.app.web.security.sample.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long>,UserRepositoryCustom {
	void deleteAllInBatch();
	User findByUsername(String username);
	Long countByUsernameAndPassword(String username, String password);
}
