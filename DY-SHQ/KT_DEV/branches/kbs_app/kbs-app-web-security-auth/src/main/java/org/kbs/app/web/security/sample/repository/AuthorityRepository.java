package org.kbs.app.web.security.sample.repository;
import org.kbs.app.web.security.sample.domain.Authority;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority,Long> {
}
