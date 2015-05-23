package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class SemesterTests extends TestCase{

	@Test
	public void testBuilding() {
		Calendar cal=Calendar.getInstance();
		Date testDate;
		Date start;
		Date end;
		Semester semester;
		
		cal.set(2014,2,9);
		testDate=cal.getTime();
		semester=new Semester(testDate,false);
		cal.set(2014,0,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(semester.getStartDate()) );
		assertTrue( end.equals(semester.getEndDate()) );

		cal.set(2014,3,9);
		testDate=cal.getTime();
		semester=new Semester(testDate,false);
		cal.set(2014,0,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(semester.getStartDate()) );
		assertTrue( end.equals(semester.getEndDate()) );
		
		cal.set(2014,4,9);
		testDate=cal.getTime();
		semester=new Semester(testDate,false);
		cal.set(2014,0,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(semester.getStartDate()) );
		assertTrue( end.equals(semester.getEndDate()) );
		
		cal.set(2014,5,9);
		testDate=cal.getTime();
		semester=new Semester(testDate,false);
		cal.set(2014,0,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(semester.getStartDate()) );
		assertTrue( end.equals(semester.getEndDate()) );

		cal.set(2014,1,9);
		testDate=cal.getTime();
		semester=new Semester(testDate,false);
		cal.set(2014,0,1);
		start=cal.getTime();
		cal.set(2014,5,30);
		end=cal.getTime();
		assertTrue( start.equals(semester.getStartDate()) );
		assertTrue( end.equals(semester.getEndDate()) );

		cal.set(2014,3,9);
		testDate=cal.getTime();
		semester=new Semester(testDate,true);
		cal.set(2014,3,1);
		start=cal.getTime();
		cal.set(2014,8,30);
		end=cal.getTime();
		assertTrue( start.equals(semester.getStartDate()) );
		assertTrue( end.equals(semester.getEndDate()) );

		cal.set(2014,9,9);
		testDate=cal.getTime();
		semester=new Semester(testDate,true);
		cal.set(2014,9,1);
		start=cal.getTime();
		cal.set(2015,2,31);
		end=cal.getTime();
		assertTrue( start.equals(semester.getStartDate()) );
		assertTrue( end.equals(semester.getEndDate()) );
	}

}
