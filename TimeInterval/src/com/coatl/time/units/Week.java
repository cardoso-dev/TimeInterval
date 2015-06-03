package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

public class Week extends TimeUnit{
	
	private int weekOfYear;
	private int weekOfMonth;
	
	public Week(){
		super();
		Calendar cal=Calendar.getInstance();
		buildWeek(cal.getTime());
	}
	
	public Week(Date anyDate){
		super();
		buildWeek(anyDate);
	}
	
	public void rebuildWeekFor(Date anyDate){
		buildWeek(anyDate);
	}
	
	private void buildWeek(Date anyDate){
		Calendar cal=Calendar.getInstance();
		cal.setTime(anyDate);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		weekOfYear=cal.get(Calendar.WEEK_OF_YEAR);
		weekOfMonth=cal.get(Calendar.WEEK_OF_MONTH);
		startDate=cal.getTime();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		endDate=cal.getTime();
		unitName="Semana";
		unitDescription=weekOfMonth+" semana "+getStartMonthName()+" "+getStartYear();
	}

	public int getWeekOfYear() {
		return weekOfYear;
	}

	public int getWeekOfMonth() {
		return weekOfMonth;
	}
}
