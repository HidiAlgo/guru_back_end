package com.find_a_guru.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.find_a_guru.domains.TeacherAdd;

@Repository
public interface TeacherAddRepository extends JpaRepository<TeacherAdd, Integer> {
	List<TeacherAdd> findByTeacherEmail(String teacher_email);
	
		//	@Query("FROM TeacherAdd WHERE grade = ?1 AND subject = ?2 AND district = ?3 AND city = ?4")
	List<TeacherAdd> findByGradeAndSubjectAndDistrictAndCity(int grade, String subject, String district, String city);
	
	List<TeacherAdd> findByGradeAndSubjectAndDistrict(int grade, String subject, String district);
}
