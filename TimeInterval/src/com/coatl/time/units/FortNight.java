package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

public class FortNight extends TimeUnit{

	private int fortNightOfMonth;
	
	public FortNight(){
		super();
		Calendar cal=Calendar.getInstance();
		buildFortnight(cal.getTime());
	}
	
	public FortNight(Date anyDate){
		super();
		buildFortnight(anyDate);
	}
	
	public void rebuildFortnightFor(Date anyDate){
		buildFortnight(anyDate);
	}
	
	private void buildFortnight(Date anyDate){
		Calendar cal=Calendar.getInstance();
		cal.setTime(anyDate);
		fortNightOfMonth=(cal.get(Calendar.DAY_OF_MONTH)<=15?1:2);
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH)<=15?1:16);
		startDate=cal.getTime();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH)<=15?15:cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate=cal.getTime();
		unitName="Quincena";
		unitDescription=fortNightOfMonth+" quincena "+getStartMonthName()+" "+getStartYear();
	}

	public int getFortNightOfMonth() {
		return fortNightOfMonth;
	}
}
