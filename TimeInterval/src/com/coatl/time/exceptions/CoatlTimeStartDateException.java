package com.coatl.time.exceptions;

import java.util.Date;

public class CoatlTimeStartDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoatlTimeStartDateException(Date start, Date end){
		super("Start date {"+start+"} is NOT before end date {"+end+"}");
	}
}
