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

public class TeacherDiplomas {
	
	@Id
	@GeneratedValue
	private int diploma_id;
	private String description;
	private String diploma_name;
	private Date end_year;
	private String institute;
	private Date started_year;
	


}
