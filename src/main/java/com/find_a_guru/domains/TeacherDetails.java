package com.find_a_guru.domains;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeacherDetails {
	
	@Id
	private String email;
	private String first_name;
	private String last_name;
	private String phone_number;
	private String password;
	private Date birth_date;
	private String nic;
	private String street_address;
	private String street_address2;
	private String city;
	private String state;
	private String zip_code;
	private String nationality;
	private String religion;
	
	@Lob
	private byte[] photo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "edu_fk", referencedColumnName = "id")
	private TeacherEducation education;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getStreet_address2() {
		return street_address2;
	}

	public void setStreet_address2(String street_address2) {
		this.street_address2 = street_address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public TeacherEducation getEducation() {
		return education;
	}

	public void setEducation(TeacherEducation education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "TeacherDetails [email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", phone_number=" + phone_number + ", password=" + password + ", birth_date=" + birth_date + ", nic="
				+ nic + ", street_address=" + street_address + ", street_address2=" + street_address2 + ", city=" + city
				+ ", state=" + state + ", zip_code=" + zip_code + ", nationality=" + nationality + ", religion="
				+ religion + ", photo=" + Arrays.toString(photo) + ", education=" + education + "]";
	}
	
	
}
