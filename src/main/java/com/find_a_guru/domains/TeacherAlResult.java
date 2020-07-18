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

public class TeacherAlResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int al_id;
	private String general_english;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="al_subs_fk", referencedColumnName = "al_id")
	private List<AlSubject> other_subjects;

	public int getAl_id() {
		return al_id;
	}

	public void setAl_id(int al_id) {
		this.al_id = al_id;
	}

	public String getGeneral_english() {
		return general_english;
	}

	public void setGeneral_english(String general_english) {
		this.general_english = general_english;
	}

	public List<AlSubject> getOther_subjects() {
		return other_subjects;
	}

	public void setOther_subjects(List<AlSubject> other_subjects) {
		this.other_subjects = other_subjects;
	}
	
	

}
