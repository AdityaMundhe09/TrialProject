package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.StudentDetailsRequest;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	@Override
	public String addStudent(StudentDetailsRequest s) {
		// TODO Auto-generated method stub
		Course c = courseRepo.findByCourseTitle(s.getCourseTitle()).orElseThrow(()-> new ResourceNotFoundException("course not found"));
		
		if(c.getMinScore()<s.getScoreObtained()) {
			c.addStudent(mapper.map(s, Student.class));
			return "Student "+s.getFirstName()+" add successfully in Course "+c.getCourseTitle();
		}
		return "Student not have enough marks";
	}


	@Override
	public List<StudentDetailsRequest> displayStudentsByCourse(String title) {
		// TODO Auto-generated method stub
		List<StudentDetailsRequest> list = new ArrayList<>();
		studentRepo.findAllByEnrolledCourseCourseTitle(title).orElseThrow(()-> new ResourceNotFoundException("students not found")).forEach((b)-> list.add(mapper.map(b, StudentDetailsRequest.class)));
		
		return list;
	}

}
