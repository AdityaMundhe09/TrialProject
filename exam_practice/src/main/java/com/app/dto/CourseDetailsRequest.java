package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CourseDetailsRequest {

//	course title(unique) , start date , end date , fees , min score
	@NotBlank(message = "title should not be null")
	private String courseTitle;
	
	@PastOrPresent(message = "start date must be present of past date")
	private LocalDate startDate;
	
	@Future(message = "endDate must be a future date")
	private LocalDate endDate;
	
	@NotNull(message = "fees should not be null")
	private double fees;
	
	@NotNull(message = "marks should not be null")
	private double minScore;
	
}
