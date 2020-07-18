package com.find_a_guru.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OlSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bucket_subject_id;
	private String subject;
	private String result;
	public int getBucket_subject_id() {
		return bucket_subject_id;
	}
	public void setBucket_subject_id(int bucket_subject_id) {
		this.bucket_subject_id = bucket_subject_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
