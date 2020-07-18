package com.find_a_guru.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeacherEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(targetEntity=TeacherDegrees.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "degree_fk", referencedColumnName = "id")
	private List<TeacherDegrees> degrees;
	
	@OneToMany(targetEntity=TeacherDiplomas.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "diploma_fk", referencedColumnName = "id")
	private List<TeacherDiplomas> diplomas;
	
	@OneToOne(targetEntity=TeacherAlResult.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "al_fk", referencedColumnName = "al_id")
	private TeacherAlResult teacherAlResult;
	
	@OneToOne(targetEntity=TeacherOlResult.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ol_fk", referencedColumnName = "ol_id")
	private TeacherOlResult teacherOlResult;
	

	

	@Override
	public String toString() {
		return "TeacherEducation [id=" + id + ", degrees=" + degrees + ", diplomas=" + diplomas + ", teacherAlResult="
				+ teacherAlResult + ", teacherOlResult=" + teacherOlResult + ", teacherDetails="  + "]";
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public List<TeacherDegrees> getDegrees() {
		return degrees;
	}




	public void setDegrees(List<TeacherDegrees> degrees) {
		this.degrees = degrees;
	}




	public List<TeacherDiplomas> getDiplomas() {
		return diplomas;
	}




	public void setDiplomas(List<TeacherDiplomas> diplomas) {
		this.diplomas = diplomas;
	}




	public TeacherAlResult getTeacherAlResult() {
		return teacherAlResult;
	}




	public void setTeacherAlResult(TeacherAlResult teacherAlResult) {
		this.teacherAlResult = teacherAlResult;
	}




	public TeacherOlResult getTeacherOlResult() {
		return teacherOlResult;
	}




	public void setTeacherOlResult(TeacherOlResult teacherOlResult) {
		this.teacherOlResult = teacherOlResult;
	}
	
	
}
