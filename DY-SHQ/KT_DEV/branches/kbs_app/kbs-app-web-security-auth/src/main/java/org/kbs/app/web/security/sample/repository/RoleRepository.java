package org.kbs.app.web.security.sample.repository;
import org.kbs.app.web.security.sample.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {
}
