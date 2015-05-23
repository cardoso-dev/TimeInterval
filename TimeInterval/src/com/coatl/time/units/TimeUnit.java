package com.coatl.time.units;

import java.util.Date;

public class TimeUnit {
	
	protected Date startDate;
	protected Date endDate;

	public TimeUnit(){
		startDate=null;
		endDate=null;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public boolean equals(TimeUnit timeUnit){
		return (startDate.equals(timeUnit.getStartDate()) && endDate.equals(timeUnit.getEndDate()));
	}
	
	public boolean contains(Date aDate){
		return ( (startDate.equals(aDate)||aDate.after(startDate)) && (endDate.equals(aDate)||aDate.before(endDate)) );
	}
}
