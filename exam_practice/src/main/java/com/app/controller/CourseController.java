package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDetailsRequest;
import com.app.dto.apiResponse;
import com.app.service.CourseService;


// comment added by Aniruddh
@RestController
@RequestMapping("/courses")
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	
//	http://host:port/courses, method=POST
	@PostMapping
	public ResponseEntity<?> addNewCourse(@RequestBody @Valid CourseDetailsRequest c){
		try {
			return new ResponseEntity<>(courseService.addCourse(c), HttpStatus.OK);
		}catch (RuntimeException e) {
			// TODO: handle exception
			return new ResponseEntity<>(new apiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
//	http://host:port/courses/10/students/20
//		method=DELETE
	
	@DeleteMapping("/{courseId}/students/{studentId}")
	public ResponseEntity<?> removeStudentFromCourse(@PathVariable Integer courseId,@PathVariable Integer studentId){
//		try {
//			return new ResponseEntity<>(courseService.removeStudentFromCourse(courseId, studentId), HttpStatus.OK);
//		}catch (RuntimeException e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(new apiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
//		}
		return new ResponseEntity<>(courseService.removeStudentFromCourse(courseId, studentId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<?> removeStudentFromCourse(@PathVariable Integer courseId){
//		try {
//			return new ResponseEntity<>(courseService.removeCourse(courseId), HttpStatus.OK);
//		}catch (RuntimeException e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(new apiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
//		}
		return new ResponseEntity<>(courseService.removeCourse(courseId), HttpStatus.OK);
	}
}
