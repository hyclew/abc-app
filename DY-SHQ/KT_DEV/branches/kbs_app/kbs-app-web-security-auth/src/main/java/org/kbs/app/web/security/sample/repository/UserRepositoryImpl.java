package org.kbs.app.web.security.sample.repository;

import org.kbs.app.web.security.sample.domain.Authority;
import org.kbs.app.web.security.sample.domain.User;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepositoryImpl implements UserRepositoryCustom {
	public static final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	public static final String DEF_USERS_BY_USERNAME_QUERY = "SELECT u FROM User u WHERE u.username=?1";
	public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY ="SELECT a FROM User u INNER JOIN u.authorities a WHERE u.username=?1";
	public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY ="SELECT a FROM User u INNER JOIN u.roles r INNER JOIN r.authorities a WHERE u.username=?1";
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		List<User> users=entityManager.createQuery(DEF_USERS_BY_USERNAME_QUERY, User.class).setParameter(1, username).setMaxResults(1).getResultList();
		if (users.size()==0) {
			throw new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.notFound",new Object[] {username}, "Username {0} not found"));
		}else{
			Set<Authority> authorities = new HashSet<Authority>();
			authorities.addAll(entityManager.createQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY, Authority.class).setParameter(1, username).getResultList());
			authorities.addAll(entityManager.createQuery(DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY, Authority.class).setParameter(1, username).getResultList());
			Set<GrantedAuthority> grantedAuthorities=new HashSet<GrantedAuthority>(authorities.size());
			for (Authority authority:authorities){
				grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
			}
			User user=users.get(0);
			//转为spring security用户和权限,多余信息移除,如果使用session保存认证用户,就可以减小内存占用.
			return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.isEnabled(),
					user.isAccountNonExpired(),user.isCredentialsNonExpired(),user.isAccountNonLocked(),grantedAuthorities);
		}
	}
}
