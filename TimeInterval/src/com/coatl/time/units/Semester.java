package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

public class Semester extends TimeUnit{

	private boolean dateLeadsFirstMonth;
	
	public Semester(){
		super();
		dateLeadsFirstMonth=true;
		Calendar cal=Calendar.getInstance();
		buildSemester(cal.getTime());
	}
	
	public Semester(Date anyDate, boolean dateLeadsFirstMonth){
		super();
		this.dateLeadsFirstMonth=dateLeadsFirstMonth;
		buildSemester(anyDate);
	}
	
	public void rebuildTrimesterFor(Date anyDate){
		buildSemester(anyDate);
	}
	
	private void buildSemester(Date anyDate){
		Calendar cal=Calendar.getInstance();
		int add=0;
		int mod;		
		cal.setTime(anyDate);
		mod=(cal.get(Calendar.MONTH)+6)%6;
		if(!dateLeadsFirstMonth && mod!=0){
			add=-mod;
		}
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+add,1);
		startDate=cal.getTime();
		cal.add(Calendar.MONTH,5);
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate=cal.getTime();
		unitName="Semestre";
		unitDescription="Semestre "+getStartMonthName()+" "+getStartYear()+"-"+getEndMonthName()+" "+getEndMonthYear();
	}

	public boolean getDateLeadsFirstMonth(){
		return dateLeadsFirstMonth;
	}
	
	public void setDateLeadsFirstMonth(boolean dateLeadsFirstMonth){
		this.dateLeadsFirstMonth=dateLeadsFirstMonth;
	}
	
}
