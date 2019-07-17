package com.basedulislam.overall_file_container;

import org.springframework.stereotype.Component;

/*
 * This is the main class of student information management system. 
 * Here we implement all features of that system. */

@Component("sims") // This annotation used for autowiring
public class Student_information_management_system {

	/* Field of information management system */
	private int id; // Student id
	private String name; // Student Name
	private String dept; // Department of student
	private String bloodGroup; // Blood group of student
	private String email; // Email of student

	
	public Student_information_management_system() {
		
	}
	
	public Student_information_management_system(String name, String dept, String bloodGroup, String email) {
		this.name = name;
		this.dept = dept;
		this.bloodGroup = bloodGroup;
		this.email = email;
	}

	/* getter and setter methods */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	/* toString method */
	@Override
	public String toString() {
		return "Student_information_management_system [id=" + id + ", name=" + name + ", dept=" + dept + ", bloodGroup="
				+ bloodGroup + ", email=" + email + "]";
	}
	

}
