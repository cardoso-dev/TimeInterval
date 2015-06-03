package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

public class Trimester extends TimeUnit{

	private boolean dateLeadsFirstMonth;
	
	public Trimester(){
		super();
		dateLeadsFirstMonth=true;
		Calendar cal=Calendar.getInstance();
		buildTrimester(cal.getTime());
	}
	
	public Trimester(Date anyDate, boolean dateLeadsFirstMonth){
		super();
		this.dateLeadsFirstMonth=dateLeadsFirstMonth;
		buildTrimester(anyDate);
	}
	
	public void rebuildTrimesterFor(Date anyDate){
		buildTrimester(anyDate);
	}
	
	private void buildTrimester(Date anyDate){
		Calendar cal=Calendar.getInstance();
		int add=0;
		int mod;		
		cal.setTime(anyDate);
		mod=(cal.get(Calendar.MONTH)+3)%3;
		if(!dateLeadsFirstMonth && mod!=0){
			add=-mod;
		}
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+add,1);
		startDate=cal.getTime();
		cal.add(Calendar.MONTH,2);
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate=cal.getTime();
		unitName="Trimestre";
		unitDescription="Trimestre "+getStartMonthName()+" "+getStartYear()+"-"+getEndMonthName()+" "+getEndMonthYear();
	}

	public boolean getDateLeadsFirstMonth(){
		return dateLeadsFirstMonth;
	}
	
	public void setDateLeadsFirstMonth(boolean dateLeadsFirstMonth){
		this.dateLeadsFirstMonth=dateLeadsFirstMonth;
	}
	
}
