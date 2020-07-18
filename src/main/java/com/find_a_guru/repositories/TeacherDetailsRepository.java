package com.find_a_guru.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.find_a_guru.domains.TeacherDetails;

@Component
public class TeacherDetailsRepository {
	
public static List<TeacherDetails> teacherDetails = new ArrayList<>();
	
//	
//	public void save(TeacherDetails details) {
//		teacherDetails.add(details);
//	}
//	
//	public TeacherDetails findByEmail(String email) {
//		for(TeacherDetails t: teacherDetails) {
//			if(t.getEmail().equals(email)) {
//				return t;
//			}
//		}
//		return null;
//	}
//	public boolean findByNic(String nic) {
//		for(TeacherDetails t : teacherDetails) {
//			if(t.getNic().equals(nic)) {
//				return true;
//			}
//		}
//		return false;
//	}
	

}
