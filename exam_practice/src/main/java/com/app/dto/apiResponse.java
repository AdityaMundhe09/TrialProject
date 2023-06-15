package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class apiResponse {

	private String msg;
	
	private LocalDateTime timestmp;

	public apiResponse(String msg) {
		super();
		this.msg = msg;
		this.timestmp = LocalDateTime.now();
	}
	
	
}
