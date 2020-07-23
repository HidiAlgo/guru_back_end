package com.find_a_guru.basicAuth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.find_a_guru.domains.TeacherDetails;
import com.find_a_guru.repositories.TeacherSignUpRepository;

@Service
public class TeacherDetailsService implements UserDetailsService {

	@Autowired
	TeacherSignUpRepository teacherSignUpRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<TeacherDetails> teacherDetails = teacherSignUpRepository.findById(email);
		
		teacherDetails.orElseThrow(() -> new UsernameNotFoundException("Username not found! "));
		
		return new TeacherLoginDetails(teacherDetails.get());
	}

}
