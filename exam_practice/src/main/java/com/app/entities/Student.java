package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//first name , last name , email , course title,score obtained.

@Entity
@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
public class Student extends BaseEntity{

	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	private double scoreObtained;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course enrolledCourse;

	public Student(String firstName, String lastName, String email, double scoreObtained) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.scoreObtained = scoreObtained;
	}
	
	
}
