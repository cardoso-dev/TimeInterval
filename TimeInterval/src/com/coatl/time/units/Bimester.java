package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

public class Bimester extends TimeUnit{

	private boolean dateLeadsFirstMonth;
	
	public Bimester(){
		super();
		dateLeadsFirstMonth=true;
		Calendar cal=Calendar.getInstance();
		buildBimester(cal.getTime());
	}
	
	public Bimester(Date anyDate, boolean dateLeadsFirstMonth){
		super();
		this.dateLeadsFirstMonth=dateLeadsFirstMonth;
		buildBimester(anyDate);
	}
	
	public void rebuildBimesterFor(Date anyDate){
		buildBimester(anyDate);
	}
	
	private void buildBimester(Date anyDate){
		Calendar cal=Calendar.getInstance();
		int add=0;
		cal.setTime(anyDate);
		if(!dateLeadsFirstMonth && ((cal.get(Calendar.MONTH)+1)%2)==0){
			add=-1;
		}
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+add,1);
		startDate=cal.getTime();
		cal.add(Calendar.MONTH,1);
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate=cal.getTime();
	}
	
	public boolean getDateLeadsFirstMonth(){
		return dateLeadsFirstMonth;
	}
	
	public void setDateLeadsFirstMonth(boolean dateLeadsFirstMonth){
		this.dateLeadsFirstMonth=dateLeadsFirstMonth;
	}
	
	
}
