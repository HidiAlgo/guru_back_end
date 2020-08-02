package com.find_a_guru.domains;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class TeacherAdd {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	private int grade;
	private String subject;
	private String district;
	private String city;
	private String phone_number;
	private String email;
	
	@Lob
	private byte[] banner;
	
	
	private int hour_price;
	private String description;
	private String teacherEmail;
	
	public TeacherAdd(int id, String title, int grade, String subject, String district, String city,
			String phone_number, String email, byte[] banner, int hour_price, String description,
			String teacherEmail) {
		this.id = id;
		this.title = title;
		this.grade = grade;
		this.subject = subject;
		this.district = district;
		this.city = city;
		this.phone_number = phone_number;
		this.email = email;
		this.banner = banner;
		this.hour_price = hour_price;
		this.description = description;
		this.teacherEmail = teacherEmail;
	}

	public TeacherAdd() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getBanner() {
		return banner;
	}

	public void setBanner(byte[] banner) {
		this.banner = banner;
	}

	public int getHour_price() {
		return hour_price;
	}

	public void setHour_price(int hour_price) {
		this.hour_price = hour_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacher_email(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	@Override
	public String toString() {
		return "TeacherAdd [id=" + id + ", title=" + title + ", grade=" + grade + ", subject=" + subject + ", district="
				+ district + ", city=" + city + ", phone_number=" + phone_number + ", email=" + email + ", banner="
				+ Arrays.toString(banner) + ", hour_price=" + hour_price + ", description=" + description
				+ ", teacher_email=" + teacherEmail + "]";
	}
	
	
	
	
	
	

}
