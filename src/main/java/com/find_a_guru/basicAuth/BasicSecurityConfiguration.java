package com.find_a_guru.basicAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	TeacherDetailsService teacherDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(teacherDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/teacher_details").hasRole("TEACHER")
//			.antMatchers("/teacher_details/validate_user").permitAll()
//			.and()
//			.formLogin();
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers("/teacher_details/validate_user").permitAll()
		.antMatchers("/teacher_details").permitAll()
		.antMatchers("/teacher_details/photo").permitAll()
		.antMatchers("/teacher_details/login").authenticated()
		.antMatchers("/teacher_details/login/user").authenticated()
		.anyRequest().permitAll()
		.and()
		.httpBasic();
		http.headers().frameOptions().disable();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	

}
