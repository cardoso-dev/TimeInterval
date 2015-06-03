package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

public class Month extends TimeUnit{
	
	public Month(){
		super();
		Calendar cal=Calendar.getInstance();
		buildMonth(cal.getTime());
	}
	
	public Month(Date anyDate){
		super();
		buildMonth(anyDate);
	}
	
	public void rebuildMonthFor(Date anyDate){
		buildMonth(anyDate);
	}
	
	private void buildMonth(Date anyDate){
		Calendar cal=Calendar.getInstance();
		cal.setTime(anyDate);
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),1);
		startDate=cal.getTime();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate=cal.getTime();
		unitName="Mes";
		unitDescription=getStartMonthName()+" "+getStartYear();
	}

}
