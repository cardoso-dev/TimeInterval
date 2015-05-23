package com.coatl.time.calculate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.coatl.time.exceptions.CoatlTimeStartDateException;
import com.coatl.time.units.Bimester;
import com.coatl.time.units.FortNight;
import com.coatl.time.units.Month;
import com.coatl.time.units.Semester;
import com.coatl.time.units.Trimester;
import com.coatl.time.units.Week;

public class CalculateIntervalsTests extends TestCase{
	
	@Test(expected=CoatlTimeStartDateException.class)
	public void testWeekCoatlTimeStartDateException() {
		CalculateIntervals calc=new CalculateIntervals();
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		cal.set(2012,9,3);
		start=cal.getTime();
		cal.set(2012,7,21);
		end=cal.getTime();
		try {
			calc.calculateWeeksBetween(start, end, false);
		} catch (CoatlTimeStartDateException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateWeeksBetween() {
		CalculateIntervals calc=new CalculateIntervals();
		List<Week> weeksFl;
		List<Week> weeksTr;
		Week wTest;
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		try {
			cal.set(2012,3,15);
			start=cal.getTime();
			cal.set(2012,7,21);
			end=cal.getTime();
			weeksFl=calc.calculateWeeksBetween(start, end, false);
			weeksTr=calc.calculateWeeksBetween(start, end, true);
			assertEquals(18,weeksFl.size());
			assertEquals(19,weeksTr.size());
			cal.set(2012,4,16);
			start=cal.getTime();
			wTest=new Week(start);			
			assertTrue(weeksFl.get(4).equals(wTest));
			
			cal.set(2014,8,22);
			start=cal.getTime();
			cal.set(2015,2,7);
			end=cal.getTime();
			weeksFl=calc.calculateWeeksBetween(start, end, false);
			weeksTr=calc.calculateWeeksBetween(start, end, true);
			assertEquals(23,weeksFl.size());
			assertEquals(24,weeksTr.size());
			cal.set(2014,11,1);
			start=cal.getTime();
			wTest=new Week(start);
			assertTrue(weeksFl.get(10).equals(wTest));
			
			cal.set(2015,0,13);
			start=cal.getTime();
			cal.set(2015,4,17);
			end=cal.getTime();
			weeksFl=calc.calculateWeeksBetween(start, end, false);
			weeksTr=calc.calculateWeeksBetween(start, end, true);
			assertEquals(17,weeksFl.size());
			assertEquals(18,weeksTr.size());
			cal.set(2015,1,11);
			start=cal.getTime();
			wTest=new Week(start);			
			assertTrue(weeksFl.get(3).equals(wTest));
		
			cal.set(2014,11,22);
			start=cal.getTime();
			cal.set(2015,3,19);
			end=cal.getTime();
			weeksFl=calc.calculateWeeksBetween(start, end, false);
			weeksTr=calc.calculateWeeksBetween(start, end, true);
			assertEquals(17,weeksFl.size());
			assertEquals(17,weeksTr.size());
			cal.set(2015,1,11);
			start=cal.getTime();
			wTest=new Week(start);			
			assertTrue(weeksFl.get(7).equals(wTest));
		} catch (CoatlTimeStartDateException e) {
			// e.printStackTrace();
		}
	}

	@Test(expected=CoatlTimeStartDateException.class)
	public void testFortNightCoatlTimeStartDateException() {
		CalculateIntervals calc=new CalculateIntervals();
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		cal.set(2012,9,3);
		start=cal.getTime();
		cal.set(2012,7,21);
		end=cal.getTime();
		try {
			calc.calculateFortNightsBetween(start, end, false);
		} catch (CoatlTimeStartDateException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateFortNightsBetween() {
		CalculateIntervals calc=new CalculateIntervals();
		List<FortNight> fortNightsFl;
		List<FortNight> fortNightsTr;
		FortNight fTest;
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		try {
			cal.set(2013,3,15);
			start=cal.getTime();
			cal.set(2013,7,21);
			end=cal.getTime();
			fortNightsFl=calc.calculateFortNightsBetween(start, end, false);
			fortNightsTr=calc.calculateFortNightsBetween(start, end, true);
			assertEquals(8,fortNightsFl.size());
			assertEquals(10,fortNightsTr.size());
			cal.set(2013,4,16);
			start=cal.getTime();
			fTest=new FortNight(start);			
			assertTrue(fortNightsFl.get(2).equals(fTest));
			
			cal.set(2014,7,16);
			start=cal.getTime();
			cal.set(2015,6,14);
			end=cal.getTime();
			fortNightsFl=calc.calculateFortNightsBetween(start, end, false);
			fortNightsTr=calc.calculateFortNightsBetween(start, end, true);
			assertEquals(21,fortNightsFl.size());
			assertEquals(22,fortNightsTr.size());
			cal.set(2015,1,18);
			start=cal.getTime();
			fTest=new FortNight(start);	
			assertTrue(fortNightsFl.get(12).equals(fTest));
			
			cal.set(2015,0,3);
			start=cal.getTime();
			cal.set(2015,4,15);
			end=cal.getTime();
			fortNightsFl=calc.calculateFortNightsBetween(start, end, false);
			fortNightsTr=calc.calculateFortNightsBetween(start, end, true);
			assertEquals(8,fortNightsFl.size());
			assertEquals(9,fortNightsTr.size());
			cal.set(2015,1,11);
			start=cal.getTime();
			fTest=new FortNight(start);			
			assertTrue(fortNightsFl.get(1).equals(fTest));
			
			cal.set(2014,10,1);
			start=cal.getTime();
			cal.set(2015,2,31);
			end=cal.getTime();
			fortNightsFl=calc.calculateFortNightsBetween(start, end, false);
			fortNightsTr=calc.calculateFortNightsBetween(start, end, true);
			assertEquals(10,fortNightsFl.size());
			assertEquals(10,fortNightsTr.size());
			cal.set(2015,1,11);
			start=cal.getTime();
			fTest=new FortNight(start);			
			assertTrue(fortNightsFl.get(6).equals(fTest));
		} catch (CoatlTimeStartDateException e) {
			// e.printStackTrace();
		}
	}

	@Test(expected=CoatlTimeStartDateException.class)
	public void testMonthCoatlTimeStartDateException() {
		CalculateIntervals calc=new CalculateIntervals();
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		cal.set(2012,9,3);
		start=cal.getTime();
		cal.set(2012,7,21);
		end=cal.getTime();
		try {
			calc.calculateMonthsBetween(start, end, false);
		} catch (CoatlTimeStartDateException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateMonthsBetween() {
		CalculateIntervals calc=new CalculateIntervals();
		List<Month> monthsFl;
		List<Month> monthsTr;
		Month mTest;
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		try {
			cal.set(2011,3,15);
			start=cal.getTime();
			cal.set(2013,7,21);
			end=cal.getTime();
			monthsFl=calc.calculateMonthsBetween(start, end, false);
			monthsTr=calc.calculateMonthsBetween(start, end, true);
			assertEquals(27,monthsFl.size());
			assertEquals(29,monthsTr.size());
			cal.set(2012,4,16);
			start=cal.getTime();
			mTest=new Month(start);			
			assertTrue(monthsFl.get(12).equals(mTest));
			
			cal.set(2014,7,1);
			start=cal.getTime();
			cal.set(2015,6,18);
			end=cal.getTime();
			monthsFl=calc.calculateMonthsBetween(start, end, false);
			monthsTr=calc.calculateMonthsBetween(start, end, true);
			assertEquals(11,monthsFl.size());
			assertEquals(12,monthsTr.size());
			cal.set(2015,1,18);
			start=cal.getTime();
			mTest=new Month(start);	
			assertTrue(monthsFl.get(6).equals(mTest));
			
			cal.set(2014,10,13);
			start=cal.getTime();
			cal.set(2015,5,30);
			end=cal.getTime();
			monthsFl=calc.calculateMonthsBetween(start, end, false);
			monthsTr=calc.calculateMonthsBetween(start, end, true);
			assertEquals(7,monthsFl.size());
			assertEquals(8,monthsTr.size());
			cal.set(2015,3,11);
			start=cal.getTime();
			mTest=new Month(start);			
			assertTrue(monthsFl.get(4).equals(mTest));
			
			cal.set(2015,1,1);
			start=cal.getTime();
			cal.set(2015,7,31);
			end=cal.getTime();
			monthsFl=calc.calculateMonthsBetween(start, end, false);
			monthsTr=calc.calculateMonthsBetween(start, end, true);
			assertEquals(7,monthsFl.size());
			assertEquals(7,monthsTr.size());
			cal.set(2015,5,26);
			start=cal.getTime();
			mTest=new Month(start);			
			assertTrue(monthsFl.get(4).equals(mTest));
		} catch (CoatlTimeStartDateException e) {
			// e.printStackTrace();
		}
	}

	@Test(expected=CoatlTimeStartDateException.class)
	public void testBimesterCoatlTimeStartDateException() {
		CalculateIntervals calc=new CalculateIntervals();
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		cal.set(2012,9,3);
		start=cal.getTime();
		cal.set(2012,7,21);
		end=cal.getTime();
		try {
			calc.calculateBimestersBetween(start, end, false,true);
		} catch (CoatlTimeStartDateException e) {
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateBimestersBetween() {
		CalculateIntervals calc=new CalculateIntervals();
		List<Bimester> bimestersFl;
		List<Bimester> bimestersTr;
		Bimester bTest;
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		try {
			cal.set(2011,3,15);
			start=cal.getTime();
			cal.set(2013,7,21);
			end=cal.getTime();
			bimestersFl=calc.calculateBimestersBetween(start, end, false, false);
			bimestersTr=calc.calculateBimestersBetween(start, end, true, false);
			assertEquals(13,bimestersFl.size());
			assertEquals(15,bimestersTr.size());
			cal.set(2012,4,16);
			start=cal.getTime();
			bTest=new Bimester(start, false);
			assertTrue(bimestersFl.get(6).equals(bTest));
			
			cal.set(2014,7,1);
			start=cal.getTime();
			cal.set(2015,6,15);
			end=cal.getTime();			
			bimestersFl=calc.calculateBimestersBetween(start, end, false, true);
			bimestersTr=calc.calculateBimestersBetween(start, end, true, true);			
			assertEquals(5,bimestersFl.size());
			assertEquals(6,bimestersTr.size());
			cal.set(2015,1,18);
			start=cal.getTime();
			bTest=new Bimester(start, true);
			assertTrue(bimestersFl.get(3).equals(bTest));
			
			cal.set(2014,10,13);
			start=cal.getTime();
			cal.set(2015,5,30);
			end=cal.getTime();
			bimestersFl=calc.calculateBimestersBetween(start, end, false, false);
			bimestersTr=calc.calculateBimestersBetween(start, end, true, false);
			assertEquals(3,bimestersFl.size());
			assertEquals(4,bimestersTr.size());
			cal.set(2015,3,11);
			start=cal.getTime();
			bTest=new Bimester(start, false);	
			assertTrue(bimestersFl.get(1).equals(bTest));
			
			cal.set(2014,5,1);
			start=cal.getTime();
			cal.set(2015,0,31);
			end=cal.getTime();
			bimestersFl=calc.calculateBimestersBetween(start, end, false, true);
			bimestersTr=calc.calculateBimestersBetween(start, end, true, true);
			assertEquals(4,bimestersFl.size());
			assertEquals(4,bimestersTr.size());
			cal.set(2014,9,11);
			start=cal.getTime();
			bTest=new Bimester(start, true);
			assertTrue(bimestersFl.get(2).equals(bTest));
		} catch (CoatlTimeStartDateException e) {
			// e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateTrimestersBetween() {
		CalculateIntervals calc=new CalculateIntervals();
		List<Trimester> trimestersFl;
		List<Trimester> trimestersTr;
		Trimester tTest;
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		try {
			cal.set(2010,3,15);
			start=cal.getTime();
			cal.set(2014,8,21);
			end=cal.getTime();
			trimestersFl=calc.calculateTrimestersBetween(start, end, false, false);
			trimestersTr=calc.calculateTrimestersBetween(start, end, true, false);
			assertEquals(16,trimestersFl.size());
			assertEquals(18,trimestersTr.size());
			cal.set(2012,7,16);
			start=cal.getTime();
			tTest=new Trimester(start, false);
			assertTrue(trimestersTr.get(9).equals(tTest));
			
			cal.set(2012,7,1);
			start=cal.getTime();
			cal.set(2015,7,19);
			end=cal.getTime();			
			trimestersFl=calc.calculateTrimestersBetween(start, end, false, true);
			trimestersTr=calc.calculateTrimestersBetween(start, end, true, true);
			assertEquals(12,trimestersFl.size());
			assertEquals(13,trimestersTr.size());
			cal.set(2015,1,18);
			start=cal.getTime();
			tTest=new Trimester(start, true);
			assertTrue(trimestersFl.get(10).equals(tTest));
			
			cal.set(2012,11,13);
			start=cal.getTime();
			cal.set(2015,5,30);
			end=cal.getTime();
			trimestersFl=calc.calculateTrimestersBetween(start, end, false, false);
			trimestersTr=calc.calculateTrimestersBetween(start, end, true, false);
			assertEquals(10,trimestersFl.size());
			assertEquals(11,trimestersTr.size());
			cal.set(2014,6,11);
			start=cal.getTime();
			tTest=new Trimester(start, false);	
			assertTrue(trimestersFl.get(6).equals(tTest));
			
			cal.set(2013,5,1);
			start=cal.getTime();
			cal.set(2015,1,28);
			end=cal.getTime();
			trimestersFl=calc.calculateTrimestersBetween(start, end, false, true);
			trimestersTr=calc.calculateTrimestersBetween(start, end, true, true);
			assertEquals(7,trimestersFl.size());
			assertEquals(7,trimestersTr.size());
			cal.set(2014,8,11);
			start=cal.getTime();
			tTest=new Trimester(start, true);
			assertTrue(trimestersFl.get(5).equals(tTest));
		} catch (CoatlTimeStartDateException e) {
			// e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateSemestersBetween() {
		CalculateIntervals calc=new CalculateIntervals();
		List<Semester> semestersFl;
		List<Semester> semestersTr;
		Semester sTest;
		Calendar cal=Calendar.getInstance();
		Date start;
		Date end;
		try {
			cal.set(2010,2,22);
			start=cal.getTime();
			cal.set(2014,10,12);
			end=cal.getTime();
			semestersFl=calc.calculateSemestersBetween(start, end, false, false);
			semestersTr=calc.calculateSemestersBetween(start, end, true, false);
			assertEquals(8,semestersFl.size());
			assertEquals(10,semestersTr.size());
			cal.set(2013,7,16);
			start=cal.getTime();
			sTest=new Semester(start, false);
			assertTrue(semestersTr.get(7).equals(sTest));
			
			cal.set(2012,2,1);
			start=cal.getTime();
			cal.set(2015,7,19);
			end=cal.getTime();			
			semestersFl=calc.calculateSemestersBetween(start, end, false, true);
			semestersTr=calc.calculateSemestersBetween(start, end, true, true);
			assertEquals(6,semestersFl.size());
			assertEquals(7,semestersTr.size());
			cal.set(2014,8,18);
			start=cal.getTime();
			sTest=new Semester(start, true);
			assertTrue(semestersFl.get(5).equals(sTest));
			
			cal.set(2012,2,13);
			start=cal.getTime();
			cal.set(2015,11,31);
			end=cal.getTime();
			semestersFl=calc.calculateSemestersBetween(start, end, false, false);
			semestersTr=calc.calculateSemestersBetween(start, end, true, false);
			assertEquals(7,semestersFl.size());
			assertEquals(8,semestersTr.size());
			cal.set(2014,6,11);
			start=cal.getTime();
			sTest=new Semester(start, false);	
			assertTrue(semestersFl.get(4).equals(sTest));
			
			cal.set(2013,1,1);
			start=cal.getTime();
			cal.set(2015,0,31);
			end=cal.getTime();
			semestersFl=calc.calculateSemestersBetween(start, end, false, true);
			semestersTr=calc.calculateSemestersBetween(start, end, true, true);
			assertEquals(4,semestersFl.size());
			assertEquals(4,semestersTr.size());
			cal.set(2014,7,11);
			start=cal.getTime();
			sTest=new Semester(start, true);
			assertTrue(semestersFl.get(3).equals(sTest));
		} catch (CoatlTimeStartDateException e) {
			// e.printStackTrace();
		}
	}

}
