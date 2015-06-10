package com.coatl.time.units;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		Calendar cal=Calendar.getInstance();
		cal.setTime(startDate);
		//sdf=new SimpleDateFormat("YYYY");
		// ** for some very very very strange reason this returns wrong year (the next year) on last day of december
		//return sdf.format(startDate);
		return ""+cal.get(Calendar.YEAR);
	}
	
	public String getEndMonthYear(){
		Calendar cal=Calendar.getInstance();
		cal.setTime(endDate);
		//sdf=new SimpleDateFormat("dd/MM/YYYY");		
		//return sdf.format(endDate); **
		// ** for some very very very strange reason this returns wrong year (the next year) on last day of december
		return ""+cal.get(Calendar.YEAR);
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
