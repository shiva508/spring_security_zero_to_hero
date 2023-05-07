package com.pool.service.registration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.model.CustomUserDetails;
import com.pool.model.Registration;
import com.pool.repository.registration.RegistrationJpa;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private RegistrationJpa registrationJpa;

	@Override
	public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Registration> registration=registrationJpa.findByUserName(userName);
		registration.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		System.out.println(registration.map(CustomUserDetails::new).get());
		return registration.map(CustomUserDetails::new).get();
	}

	@Transactional
    public UserDetails loadUserById(Integer userId) {
		Optional<Registration> registration= registrationJpa.findById(userId);
		registration.orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + userId)
        );
        return registration.map(CustomUserDetails::new).get();
    }

}
