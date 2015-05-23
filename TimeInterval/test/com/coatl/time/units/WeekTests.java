package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class WeekTests extends TestCase{

	@Test
	public void testBuilding() {
		Calendar cal=Calendar.getInstance();
		Date testDate;
		Date start;
		Date end;
		Week week;
		
		cal.set(2011,03,15);
		testDate=cal.getTime();
		week=new Week(testDate);
		cal.set(2011,03,11);
		start=cal.getTime();
		cal.set(2011,03,17);
		end=cal.getTime();
		assertTrue( start.equals(week.getStartDate()) );
		assertTrue( end.equals(week.getEndDate()) );
		assertEquals( 16,week.getWeekOfYear() );
		
		cal.set(2011,8,8);
		testDate=cal.getTime();
		week=new Week(testDate);
		cal.set(2011,8,5);
		start=cal.getTime();
		cal.set(2011,8,11);
		end=cal.getTime();
		assertTrue( start.equals(week.getStartDate()) );
		assertTrue( end.equals(week.getEndDate()) );
		assertEquals( 37,week.getWeekOfYear() );
		
		cal.set(2012,5,2);
		testDate=cal.getTime();
		week=new Week(testDate);
		cal.set(2012,4,28);
		start=cal.getTime();
		cal.set(2012,5,3);
		end=cal.getTime();
		assertTrue( start.equals(week.getStartDate()) );
		assertTrue( end.equals(week.getEndDate()) );
		assertEquals( 23,week.getWeekOfYear() );
		
		cal.set(2013,7,28);
		testDate=cal.getTime();
		week=new Week(testDate);
		cal.set(2013,7,26);
		start=cal.getTime();
		cal.set(2013,8,1);
		end=cal.getTime();
		assertTrue( start.equals(week.getStartDate()) );
		assertTrue( end.equals(week.getEndDate()) );
		assertEquals( 35,week.getWeekOfYear() );
		
		cal.set(2013,11,19);
		testDate=cal.getTime();
		week=new Week(testDate);
		cal.set(2013,11,16);
		start=cal.getTime();
		cal.set(2013,11,22);
		end=cal.getTime();
		assertTrue( start.equals(week.getStartDate()) );
		assertTrue( end.equals(week.getEndDate()) );
		assertEquals( 51,week.getWeekOfYear() );
		
		cal.set(2014,6,11);
		testDate=cal.getTime();
		week=new Week(testDate);
		cal.set(2014,6,7);
		start=cal.getTime();
		cal.set(2014,6,13);
		end=cal.getTime();
		assertTrue( start.equals(week.getStartDate()) );
		assertTrue( end.equals(week.getEndDate()) );
		assertEquals( 28,week.getWeekOfYear() );
		
		cal.set(2015,4,22);
		testDate=cal.getTime();
		week=new Week(testDate);
		cal.set(2015,4,18);
		start=cal.getTime();
		cal.set(2015,4,24);
		end=cal.getTime();
		assertTrue( start.equals(week.getStartDate()) );
		assertTrue( end.equals(week.getEndDate()) );
		assertEquals( 21,week.getWeekOfYear() );
	}

}
