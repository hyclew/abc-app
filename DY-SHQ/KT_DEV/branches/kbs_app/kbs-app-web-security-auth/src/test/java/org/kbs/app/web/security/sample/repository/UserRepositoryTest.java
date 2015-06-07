package org.kbs.app.web.security.sample.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kbs.app.web.security.sample.config.AppConfig;
import org.kbs.app.web.security.sample.domain.Authority;
import org.kbs.app.web.security.sample.domain.Role;
import org.kbs.app.web.security.sample.domain.User;
import org.kbs.app.web.security.sample.repository.AuthorityRepository;
import org.kbs.app.web.security.sample.repository.RoleRepository;
import org.kbs.app.web.security.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { AppConfig.class })
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AuthorityRepository authorityRepository;

	@Test
	public void testSave() {
		try {
			User user = new User();
			user.setUsername("username");
			user.setPassword("password");
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindAll() {
		Iterable<User> users = userRepository.findAll();
		for (User user : users) {
			System.out.println(user.getUsername());
		}
	}

	@Test
	public void testFindByUsername() {
		User user = userRepository.findByUsername("admin");
		System.out.println(user);
	}

	@Test
	public void testLoadUserByUsername() {
		try {
			UserDetails user = userRepository.loadUserByUsername("admin");
			System.out.println(user.getAuthorities());
		} catch (Exception e) {

		}
	}

	@Test
	public void testInitUsers() {
		try {
			Authority authority1 = new Authority();
			authority1.setName("查看用户");
			authority1.setAuthority("USER_QUERY");
			authorityRepository.save(authority1);
			Authority authority2 = new Authority();
			authority2.setName("保存用户");
			authority2.setAuthority("USER_SAVE");
			authorityRepository.save(authority2);
			Authority authority3 = new Authority();
			authority3.setName("删除用户");
			authority3.setAuthority("USER_DELETE");
			authorityRepository.save(authority3);
			Role role1 = new Role();
			role1.setName("管理员");
			role1.setAuthorities(new HashSet<Authority>(Arrays.asList(
					authority2, authority3)));
			roleRepository.save(role1);
			User user1 = new User();
			user1.setUsername("admin");
			user1.setPassword("$2a$04$fCqcakHV2O.4AJgp3CIAGO9l5ZBq61Gt6YNzjcyC8M.js0ucpyun.");// admin
			user1.setCredentialsNonExpired(true);
			user1.setAccountNonLocked(true);
			user1.setEnabled(true);
			user1.setAccountNonExpired(true);
			user1.setAuthorities(new HashSet<Authority>(Arrays
					.asList(authority1)));
			user1.setRoles(new HashSet<Role>(Arrays.asList(role1)));
			userRepository.save(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
