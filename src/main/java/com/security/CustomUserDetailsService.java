package com.security;


import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<SimpleGrantedAuthority> roles = null;
		
		if(username.equals("admin"))
		{
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin","$2a$10$ZtUH2URmsaNXUqE4NwsPZexJUKNXeJrZHuogSSK9pwcUIsdBMWVQe" , roles);
		}
		if(username.equals("user"))
		{
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			return new User("admin","$2a$10$a8VEk.gxIG.fFwQ/kv9hwuC2RrulIQ8OHHtjBjiSvYnvxWrV8St/2" , roles);
		}
		
		
		throw new UsernameNotFoundException("User not found with the name" + username) ;
	}

}
