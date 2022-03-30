package com.examly.springapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(2)
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserDetailsService userDetailsServiceImpl;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/user/**")
			.authorizeRequests().anyRequest().authenticated()
			.and().formLogin().loginPage("user/login")
				.defaultSuccessUrl("user/dashboard", true)
				.failureUrl("user/accessdenied")
			.permitAll()
			.and().logout().logoutUrl("/user/logout").logoutSuccessUrl("user/login");
		
		http.csrf().disable();
	}	
}
