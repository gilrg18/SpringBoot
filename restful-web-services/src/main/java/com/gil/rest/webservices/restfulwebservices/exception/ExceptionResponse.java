package com.gil.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
	//Whenever a exception happens we want to return a response back with this specific format
	// timestamp
	private Date timestamp;
	// message
	private String message;
	// detail
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
