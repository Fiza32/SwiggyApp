package com.masai.exception;

import java.time.LocalDateTime;


public class MyErrorDetails {
	private LocalDateTime timestamp;
	private String error;
	private String errorDetails;
	
	public MyErrorDetails(LocalDateTime timestamp, String error, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.errorDetails = errorDetails;
	}
	
	
}
