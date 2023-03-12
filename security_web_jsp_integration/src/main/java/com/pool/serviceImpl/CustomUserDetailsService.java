package com.pool.serviceImpl;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pool.dao.UserRepository;
import com.pool.model.CustomUser;
import com.pool.model.User;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User>optionalUsers=userRepository.findByUserName(username);
		optionalUsers.orElseThrow(()->new UsernameNotFoundException("USER NAME NOT FOUND"));
		System.out.println(optionalUsers.get());
		return optionalUsers.map(CustomUser::new).get();
	}
	
	public void addUserToSession(HttpServletRequest request) {
			
	}
}
