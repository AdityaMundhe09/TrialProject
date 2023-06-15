package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{

	Optional<Course> findByCourseTitle(String title);
}
