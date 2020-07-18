package com.find_a_guru.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class TeacherDegrees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int degree_id;
	private String degree_title;
	private String description;
	private Date end_year;
	private Date started_year;
	private String university;
	
	
}
