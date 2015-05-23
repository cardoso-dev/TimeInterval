package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class TrimesterTests extends TestCase{

	@Test
	public void testBuilding() {
		Calendar cal=Calendar.getInstance();
		Date testDate;
		Date start;
		Date end;
		Trimester trimester;
		
		cal.set(2014,5,9);
		testDate=cal.getTime();
		trimester=new Trimester(testDate,false);
		cal.set(2014,3,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(trimester.getStartDate()) );
		assertTrue( end.equals(trimester.getEndDate()) );

		cal.set(2014,4,9);
		testDate=cal.getTime();
		trimester=new Trimester(testDate,false);
		cal.set(2014,3,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(trimester.getStartDate()) );
		assertTrue( end.equals(trimester.getEndDate()) );
		
		cal.set(2014,3,9);
		testDate=cal.getTime();
		trimester=new Trimester(testDate,false);
		cal.set(2014,3,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(trimester.getStartDate()) );
		assertTrue( end.equals(trimester.getEndDate()) );
		
		cal.set(2014,5,9);
		testDate=cal.getTime();
		trimester=new Trimester(testDate,true);
		cal.set(2014,5,1);
		start=cal.getTime();
		cal.set(2014,7,31);
		end=cal.getTime();
		assertTrue( start.equals(trimester.getStartDate()) );
		assertTrue( end.equals(trimester.getEndDate()) );

		cal.set(2014,4,9);
		testDate=cal.getTime();
		trimester=new Trimester(testDate,true);
		cal.set(2014,4,1);
		start=cal.getTime();
		cal.set(2014,6,31);
		end=cal.getTime();
		assertTrue( start.equals(trimester.getStartDate()) );
		assertTrue( end.equals(trimester.getEndDate()) );
	}

}
