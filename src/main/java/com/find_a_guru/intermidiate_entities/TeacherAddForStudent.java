package com.find_a_guru.intermidiate_entities;

import com.find_a_guru.domains.TeacherAdd;

public class TeacherAddForStudent {
	private String name;
	private byte[] photo;
	
	private TeacherAdd teacherAdd;
	
	
	public TeacherAddForStudent(String name, byte[] photo, TeacherAdd teacherAdd) {
		super();
		this.name = name;
		this.photo = photo;
		this.teacherAdd = teacherAdd;
	}
	
	public TeacherAddForStudent() {}
	
	public TeacherAdd getTeacherAdd() {
		return teacherAdd;
	}

	public void setTeacherAdd(TeacherAdd teacherAdd) {
		this.teacherAdd = teacherAdd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
	
	
}
