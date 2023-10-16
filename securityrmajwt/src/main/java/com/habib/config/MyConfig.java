package com.habib.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.habib.service.MyUserService;


@Configuration
@EnableWebSecurity
public class MyConfig {

	@Autowired
	MyUserService service;
	@Autowired
    JwtAuthenticationFilter jwtAuthFilter;

    
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration auth) throws Exception
	{
		return auth.getAuthenticationManager();
	}
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		
	 		http
	 		.csrf(d->d.disable())
	 			.authorizeHttpRequests((authorizeHttpRequests) ->
	 				authorizeHttpRequests
	 					.requestMatchers("/auth/**").permitAll()
	 					.requestMatchers("/users/**").hasAuthority("admin")
	 					.requestMatchers("/test").hasAuthority("user") 
	 					.anyRequest()
	 					.authenticated()
	 					
	 	       
	 			)
//	 			.formLogin(  f->f.permitAll() )
	 			   .sessionManagement(ses->ses
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  
	                )
	 			  .authenticationProvider(authenticationProvider())
	               .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
	 			;
	 		return http.build();
	 	}

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
		

	@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(service);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
		
	}
	

