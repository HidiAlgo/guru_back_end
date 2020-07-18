package com.find_a_guru.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.find_a_guru.repositories.TeacherDetailsRepository;
import com.find_a_guru.repositories.TeacherSignUpRepository;
import com.find_a_guru.domains.TeacherDetails;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TeacherSignUpController {

	@Autowired
	TeacherSignUpRepository teacherRepo;
	
	@GetMapping("/teacher_details")
	public List<TeacherDetails> getTeacherDetails(){
		return teacherRepo.findAll();
	}
	
	@PostMapping("/teacher_details")
	public void saveTeacherDetails(@RequestBody TeacherDetails teacherDetails) {
		teacherRepo.save(teacherDetails);
	}
	
	@RequestMapping( value ="/teacher_details/photo", method= RequestMethod.POST, consumes = { "multipart/form-data" })
	public void saveTeacherPhoto(@RequestParam("email") String email, @RequestParam("image") MultipartFile image) throws IOException {
		System.out.println("Here is the image ---  "+image.getBytes());
		TeacherDetails teacherDetails = teacherRepo.findById(email).get();
		teacherDetails.setPhoto(image.getBytes());
		teacherRepo.save(teacherDetails);
	}
	
	@PostMapping("/teacher_details/validate_user")
	public ResponseEntity<String> validateUser(@RequestBody TeacherDetails teacherDetails){
		System.out.println(teacherRepo.findById(teacherDetails.getEmail()));
		if(teacherRepo.findById(teacherDetails.getEmail()).isPresent()) {
			return new ResponseEntity<>("1", HttpStatus.BAD_REQUEST);
		}else if(teacherRepo.findByNic(teacherDetails.getNic()) != null) {
			return new ResponseEntity<>("2", HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>("OK", HttpStatus.OK);
		}
//		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
