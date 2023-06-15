package com.app.service;

import com.app.dto.CourseDetailsRequest;

public interface CourseService {

	String addCourse(CourseDetailsRequest c);
	
	String removeStudentFromCourse(Integer courseId,Integer studentId);

	String removeCourse(Integer courseId);
}
