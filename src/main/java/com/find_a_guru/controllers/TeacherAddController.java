package com.find_a_guru.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.find_a_guru.domains.TeacherAdd;
import com.find_a_guru.domains.TeacherDetails;
import com.find_a_guru.intermidiate_entities.TeacherAddForStudent;
import com.find_a_guru.repositories.TeacherAddRepository;
import com.find_a_guru.repositories.TeacherSignUpRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TeacherAddController {
	
	@Autowired
	TeacherAddRepository teacherAddRepo;
	
	@Autowired
	TeacherSignUpRepository teacherSignUpRepo;
	
	@GetMapping("/teacher_details/getAdds/{email}")
	public List<TeacherAdd> getTeacherAddsForATeacher(@PathVariable String email){
		return teacherAddRepo.findByTeacherEmail(email);
	}
	
	@RequestMapping(value="/teacher_details/create_add", method=RequestMethod.POST)
	public TeacherAdd addTeacherAdd(@RequestBody TeacherAdd add) throws IOException {
		return teacherAddRepo.save(add);
	}
	
	
	@RequestMapping(value="/teacher_details/create_add/banner", method=RequestMethod.POST, consumes= {"multipart/form-data"})
	public void addTeacherAddBanner(@RequestParam("id") int id, @RequestParam("banner") MultipartFile banner) throws IOException {
		TeacherAdd teacherAdd = teacherAddRepo.findById(id).get();
		teacherAdd.setBanner(banner.getBytes());
		teacherAddRepo.save(teacherAdd);
	}
	
	@GetMapping("/student_dashboard/get_adds/{grade}/{subject}/{district}/{city}")
	public List<TeacherAddForStudent> getAdds(@PathVariable int grade, @PathVariable String subject, @PathVariable String district, @PathVariable String city ){
		List<TeacherAdd> teacherAdds = teacherAddRepo.findByGradeAndSubjectAndDistrictAndCity(grade, subject, district, city);
		List<TeacherAddForStudent> teacherAddsForStudent = new ArrayList<>();
		for(TeacherAdd add: teacherAdds) {
			TeacherAddForStudent t = new TeacherAddForStudent();
			TeacherDetails teacher= teacherSignUpRepo.findById(add.getTeacherEmail()).get();
			String teacheName = teacher.getFirst_name() + " "+teacher.getLast_name();
			t.setTeacherAdd(add);
			t.setName(teacheName);
			t.setPhoto(teacher.getPhoto());
			
			teacherAddsForStudent.add(t);
		}
		
		return teacherAddsForStudent;
	}
	
}
