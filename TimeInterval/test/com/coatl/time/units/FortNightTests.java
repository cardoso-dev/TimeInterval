package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class FortNightTests extends TestCase{

	@Test
	public void test() {
		Calendar cal=Calendar.getInstance();
		Date testDate;
		Date start;
		Date end;
		FortNight fortNight;
		
		cal.set(2012,4,9);
		testDate=cal.getTime();
		fortNight=new FortNight(testDate);
		cal.set(2012,4,1);
		start=cal.getTime();
		cal.set(2012,4,15);
		end=cal.getTime();	
		assertTrue( start.equals(fortNight.getStartDate()) );
		assertTrue( end.equals(fortNight.getEndDate()) );
		assertEquals( 1,fortNight.getFortNightOfMonth() );
		
		cal.set(2012,1,20);
		testDate=cal.getTime();
		fortNight=new FortNight(testDate);
		cal.set(2012,1,16);
		start=cal.getTime();
		cal.set(2012,1,29);
		end=cal.getTime();
		assertTrue( start.equals(fortNight.getStartDate()) );
		assertTrue( end.equals(fortNight.getEndDate()) );
		assertEquals( 2,fortNight.getFortNightOfMonth() );
		
		cal.set(2013,7,19);
		testDate=cal.getTime();
		fortNight=new FortNight(testDate);
		cal.set(2013,7,16);
		start=cal.getTime();
		cal.set(2013,7,31);
		end=cal.getTime();
		assertTrue( start.equals(fortNight.getStartDate()) );
		assertTrue( end.equals(fortNight.getEndDate()) );
		assertEquals( 2,fortNight.getFortNightOfMonth() );
		
		cal.set(2015,3,12);
		testDate=cal.getTime();
		fortNight=new FortNight(testDate);
		cal.set(2015,3,1);
		start=cal.getTime();
		cal.set(2015,3,15);
		end=cal.getTime();	
		assertTrue( start.equals(fortNight.getStartDate()) );
		assertTrue( end.equals(fortNight.getEndDate()) );
		assertEquals( 1,fortNight.getFortNightOfMonth() );
		
		cal.set(2015,8,25);
		testDate=cal.getTime();
		fortNight=new FortNight(testDate);
		cal.set(2015,8,16);
		start=cal.getTime();
		cal.set(2015,8,30);
		end=cal.getTime();	
		assertTrue( start.equals(fortNight.getStartDate()) );
		assertTrue( end.equals(fortNight.getEndDate()) );
		assertEquals( 2,fortNight.getFortNightOfMonth() );
	}

}
