package com.coatl.time.units;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUnit {
	
	private SimpleDateFormat sdf;
	protected Date startDate;
	protected Date endDate;
	protected String unitName;
	protected String unitDescription;

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
	
	public String getStartMonthName(){
		sdf=new SimpleDateFormat("MMMM");
		return sdf.format(startDate);
	}
	
	public String getEndMonthName(){
		sdf=new SimpleDateFormat("MMMM");
		return sdf.format(endDate);
	}
	
	public String getStartYear(){
		sdf=new SimpleDateFormat("YYYY");
		return sdf.format(startDate);
	}
	
	public String getEndMonthYear(){
		sdf=new SimpleDateFormat("YYYY");
		return sdf.format(endDate);
	}
	
	public boolean equals(TimeUnit timeUnit){
		return (startDate.equals(timeUnit.getStartDate()) && endDate.equals(timeUnit.getEndDate()));
	}
	
	public boolean contains(Date aDate){
		return ( (startDate.equals(aDate)||aDate.after(startDate)) && (endDate.equals(aDate)||aDate.before(endDate)) );
	}

	public String getUnitName() {
		return unitName;
	}

	public String getUnitDescription() {
		return unitDescription;
	}	
}
