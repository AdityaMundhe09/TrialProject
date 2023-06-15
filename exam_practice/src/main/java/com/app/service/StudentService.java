package com.app.service;

import java.util.List;

import com.app.dto.StudentDetailsRequest;

public interface StudentService {

	String addStudent(StudentDetailsRequest s);
	
	List<StudentDetailsRequest> displayStudentsByCourse(String title);
}
