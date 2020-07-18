package com.find_a_guru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.find_a_guru.domains.TeacherDetails;

@Repository
public interface TeacherSignUpRepository extends JpaRepository<TeacherDetails, String>{
	TeacherDetails findByNic(String nic);
}
