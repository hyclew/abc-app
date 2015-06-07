package org.kbs.app.web.security.sample.service.impl;
import org.kbs.app.web.security.sample.domain.User;
import org.kbs.app.web.security.sample.repository.UserRepository;
import org.kbs.app.web.security.sample.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {
	@Autowired
	private UserRepository userRepository;
	public Page<User> findAll(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	public User save(User user) {
		return userRepository.save(user);
	}
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
