package com.coatl.time.units;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class BimesterTests extends TestCase{

	@Test
	public void testBuilding() {
		Calendar cal=Calendar.getInstance();
		Date testDate;
		Date start;
		Date end;
		Bimester bimester;
		
		cal.set(2014,7,4);
		testDate=cal.getTime();
		bimester=new Bimester(testDate,false);
		cal.set(2014,6,1);
		start=cal.getTime();
		cal.set(2014,7,31);
		end=cal.getTime();
		assertTrue( start.equals(bimester.getStartDate()) );
		assertTrue( end.equals(bimester.getEndDate()) );
		
		cal.set(2014,7,4);
		testDate=cal.getTime();
		bimester=new Bimester(testDate,true);
		cal.set(2014,7,1);
		start=cal.getTime();
		cal.set(2014,8,30);
		end=cal.getTime();
		assertTrue( start.equals(bimester.getStartDate()) );
		assertTrue( end.equals(bimester.getEndDate()) );
		
		cal.set(2015,1,18);
		testDate=cal.getTime();
		bimester=new Bimester(testDate,false);
		cal.set(2015,0,1);
		start=cal.getTime();
		cal.set(2015,1,28);
		end=cal.getTime();
		assertTrue( start.equals(bimester.getStartDate()) );
		assertTrue( end.equals(bimester.getEndDate()) );
		
		cal.set(2015,1,18);
		testDate=cal.getTime();
		bimester=new Bimester(testDate,true);
		cal.set(2015,1,1);
		start=cal.getTime();
		cal.set(2015,2,31);
		end=cal.getTime();
		assertTrue( start.equals(bimester.getStartDate()) );
		assertTrue( end.equals(bimester.getEndDate()) );
	}
}
