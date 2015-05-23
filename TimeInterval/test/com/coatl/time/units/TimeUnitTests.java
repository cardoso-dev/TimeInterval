package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class TimeUnitTests extends TestCase{

	@Test
	public void testContains() {
		Calendar cal=Calendar.getInstance();
		Date testDate;
		TimeUnit timeUnit;
		
		cal.set(2014,7,4);
		testDate=cal.getTime();
		timeUnit=new Bimester(testDate,false);
		cal.set(2014,6,13);
		testDate=cal.getTime();
		assertTrue( timeUnit.contains(testDate) );
		cal.set(2014,7,22);
		testDate=cal.getTime();
		assertTrue( timeUnit.contains(testDate) );
		cal.set(2014,4,22);
		testDate=cal.getTime();
		assertFalse( timeUnit.contains(testDate) );
		cal.set(2014,8,2);
		testDate=cal.getTime();
		assertFalse( timeUnit.contains(testDate) );
		
		cal.set(2015,1,5);
		testDate=cal.getTime();
		timeUnit=new Trimester(testDate,true);
		cal.set(2015,3,13);
		testDate=cal.getTime();
		assertTrue( timeUnit.contains(testDate) );
		cal.set(2015,8,2);
		testDate=cal.getTime();
		assertFalse( timeUnit.contains(testDate) );
		
		cal.set(2015,0,15);
		testDate=cal.getTime();
		timeUnit=new Semester(testDate,true);
		cal.set(2015,4,22);
		testDate=cal.getTime();
		assertTrue( timeUnit.contains(testDate) );
		cal.set(2014,11,2);
		testDate=cal.getTime();
		assertFalse( timeUnit.contains(testDate) );
	}
}
