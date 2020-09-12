package com.find_a_guru.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/teacher_details/getAdd/{id}")
	public TeacherAdd getTeacherAddForTeacher(@PathVariable int id) {
		return teacherAddRepo.findById(id).get();
	}
	
	@RequestMapping(value="/teacher_details/create_add", method=RequestMethod.POST)
	public TeacherAdd addTeacherAdd(@RequestBody TeacherAdd add) throws IOException {
		return teacherAddRepo.save(add);
	}
	
	@GetMapping(value="/teacher_details/getAddCount/{email}")
	public int getNumberOfAdds(@PathVariable String email) {
		return (int)teacherAddRepo.findByTeacherEmail(email).stream().count();
	}
	
	@PutMapping(value = "/teacher_details/edit_add")
	public void editAdd(@RequestBody TeacherAdd add) {
		TeacherAdd oldAdd = teacherAddRepo.findById(add.getId()).get();
		oldAdd.setTitle(add.getTitle());
		oldAdd.setCity(add.getCity());
		oldAdd.setDescription(add.getDescription());
		oldAdd.setDistrict(add.getDistrict());
		oldAdd.setEmail(add.getEmail());
		oldAdd.setGrade(add.getGrade());
		oldAdd.setHour_price(add.getHour_price());
		oldAdd.setPhone_number(add.getPhone_number());
		oldAdd.setSubject(add.getSubject());
		
		teacherAddRepo.save(oldAdd);
	}
	
	
	@RequestMapping(value="/teacher_details/create_add/banner", method=RequestMethod.POST, consumes= {"multipart/form-data"})
	public void addTeacherAddBanner(@RequestParam("id") int id, @RequestParam("banner") MultipartFile banner) throws IOException {
		TeacherAdd teacherAdd = teacherAddRepo.findById(id).get();
		teacherAdd.setBanner(banner.getBytes());
		teacherAddRepo.save(teacherAdd);
	}
	

	@RequestMapping(value="/teacher_details/create_add/banner/byte", method=RequestMethod.PUT, consumes= {"multipart/form-data"})
	public void addTeacherAddBannerByte(@RequestParam("id") int id, @RequestParam("banner") byte[] banner) throws IOException {
		System.out.println("Hello i am here buddy");
		TeacherAdd teacherAdd = teacherAddRepo.findById(id).get();
		teacherAdd.setBanner(banner);
		teacherAddRepo.save(teacherAdd);
	}
	
	@GetMapping("/teacher_details/delete_add/{id}")
	public void deleteAdd(@PathVariable int id) {
		teacherAddRepo.deleteById(id);
	}
	
	@GetMapping("/student_dashboard/get_adds/{grade}/{subject}/{district}/{city}")
	public List<TeacherAddForStudent> getAdds(@PathVariable int grade, @PathVariable String subject, @PathVariable String district, @PathVariable String city ){
		List<TeacherAdd> teacherAdds;
		if(city.substring(0, 6).equals("All of")) {
			teacherAdds = teacherAddRepo.findByGradeAndSubjectAndDistrict(grade, subject, district);
		}else {
			teacherAdds = teacherAddRepo.findByGradeAndSubjectAndDistrictAndCity(grade, subject, district, city);
			List<TeacherAdd> allAdds = teacherAddRepo.findByGradeAndSubjectAndDistrictAndCity(grade, subject, district, district);
			for(TeacherAdd a : allAdds) {
				teacherAdds.add(a);
			}
		}
		
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
