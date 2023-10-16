package com.habib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.habib.repo.IUser;


@Service
public class MyUserService implements UserDetailsService{

	@Autowired
	IUser urepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		return urepo.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException(username));
		 
	}

}
