package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDetailsRequest;
import com.app.dto.apiResponse;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping
	public ResponseEntity<?> addNewStudent(@RequestBody @Valid StudentDetailsRequest s){
//		try {
//			return new ResponseEntity<>(new apiResponse(studentService.addStudent(s)), HttpStatus.OK);
//		}catch (RuntimeException e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(new apiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
//		}
		return new ResponseEntity<>(new apiResponse(studentService.addStudent(s)), HttpStatus.OK);
		
	}
	
//	http://host:port/students/course_title/Mastering Java 
//		method=GET
	
	@GetMapping("course_title/{courseTitle}")
	public ResponseEntity<?> displayStudentsByCourse(@PathVariable String courseTitle){
//		try {
//			return new ResponseEntity<>(studentService.displayStudentsByCourse(courseTitle), HttpStatus.OK);
//		}catch (RuntimeException e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(new apiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
//		}
		return new ResponseEntity<>(studentService.displayStudentsByCourse(courseTitle), HttpStatus.OK);
	}
}
