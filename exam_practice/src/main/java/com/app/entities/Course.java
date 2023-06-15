package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//course title(unique) , start date , end date , fees , min score


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="courses")
public class Course extends BaseEntity{
	
	@Column(unique = true)
	private String courseTitle;
	
	
	private LocalDate startDate;
	
	
	private LocalDate endDate;
	
	
	
	private double fees;
	
	
	private double minScore;
	
	@OneToMany(mappedBy = "enrolledCourse",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Student> students = new ArrayList<>();

	public Course(String courseTitle, LocalDate startDate, LocalDate endDate, double fees, double minScore) {
		super();
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minScore = minScore;
	}
	
	
	public void addStudent(Student s) {
		students.add(s);
		s.setEnrolledCourse(this);
	}
	
	public void removeStudent(Student s) {
		students.remove(s);
		s.setEnrolledCourse(null);
	}
}
