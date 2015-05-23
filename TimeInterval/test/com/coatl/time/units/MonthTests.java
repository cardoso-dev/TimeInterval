package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class MonthTests extends TestCase{

	@Test
	public void testBuilding() {
		Calendar cal=Calendar.getInstance();
		Date testDate;
		Date start;
		Date end;
		Month month;
		
		cal.set(2013,10,4);
		testDate=cal.getTime();
		month=new Month(testDate);
		cal.set(2013,10,1);
		start=cal.getTime();
		cal.set(2013,10,30);
		end=cal.getTime();
		assertTrue( start.equals(month.getStartDate()) );
		assertTrue( end.equals(month.getEndDate()) );
		
		cal.set(2014,0,25);
		testDate=cal.getTime();
		month=new Month(testDate);
		cal.set(2014,0,1);
		start=cal.getTime();
		cal.set(2014,0,31);
		end=cal.getTime();
		assertTrue( start.equals(month.getStartDate()) );
		assertTrue( end.equals(month.getEndDate()) );
	}

}
