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
public class TeacherOlResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ol_id;
	private String mathematics;
	private String english;
	private String history;
	private String sinhala;
	private String science;
	private String religion_subject;
	
	@OneToMany(targetEntity=OlSubject.class, cascade = CascadeType.ALL)
	@JoinColumn(name="ol_subs_fk", referencedColumnName="ol_id")
	private List<OlSubject> bucket_subjects;

	public int getOl_id() {
		return ol_id;
	}

	public void setOl_id(int ol_id) {
		this.ol_id = ol_id;
	}

	public String getMathematics() {
		return mathematics;
	}

	public void setMathematics(String mathematics) {
		this.mathematics = mathematics;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getSinhala() {
		return sinhala;
	}

	public void setSinhala(String sinhala) {
		this.sinhala = sinhala;
	}

	public String getScience() {
		return science;
	}

	public void setScience(String science) {
		this.science = science;
	}

	public String getReligion_subject() {
		return religion_subject;
	}

	public void setReligion_subject(String religion_subject) {
		this.religion_subject = religion_subject;
	}

	public List<OlSubject> getBucket_subjects() {
		return bucket_subjects;
	}

	public void setBucket_subjects(List<OlSubject> bucket_subjects) {
		this.bucket_subjects = bucket_subjects;
	}
	
	
	
	
}
