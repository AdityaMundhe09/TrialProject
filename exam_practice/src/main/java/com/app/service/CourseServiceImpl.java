package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.CourseDetailsRequest;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public String addCourse(CourseDetailsRequest c) {
		// TODO Auto-generated method stub
		Course c1 = repo.save(mapper.map(c, Course.class));
		return "Course"+c1.getCourseTitle()+" added successfully";
	}


	@Override
	public String removeStudentFromCourse(Integer courseId, Integer studentId) {
		// TODO Auto-generated method stub
		Course c = repo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("course not found"));
		
		Student s = studentRepo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student not found"));
		
		c.removeStudent(s);
		
		return "Student "+ s.getFirstName() + " is removed from Course "+ c.getCourseTitle() ;
	}


	@Override
	public String removeCourse(Integer courseId) {
		// TODO Auto-generated method stub
		repo.deleteById(courseId);
		return "course deleted";
	}

}
