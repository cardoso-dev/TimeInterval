package com.coatl.time.calculate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.coatl.time.exceptions.CoatlTimeStartDateException;
import com.coatl.time.units.Bimester;
import com.coatl.time.units.FortNight;
import com.coatl.time.units.Month;
import com.coatl.time.units.Semester;
import com.coatl.time.units.Trimester;
import com.coatl.time.units.Week;

public class CalculateIntervals {

	public List<Week> calculateWeeksBetween(Date start, Date end, boolean roundUp) throws CoatlTimeStartDateException{
		List<Week> weeks;
		Calendar cal;
		Week startWeek;
		Week endWeek;
		Week currWeek;
		boolean flag=true;
		if( !startDateItsBefore(start,end) ){
			throw new CoatlTimeStartDateException(start,end);
		}
		cal=Calendar.getInstance();
		weeks=new ArrayList<Week>();
		startWeek=new Week(start);
		endWeek=new Week(end);
		cal.setTime(start);
		if( roundUp || (!roundUp && cal.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY) ){
			weeks.add(startWeek);
		}
		do{
			cal.add(Calendar.DATE,7);
			if( !cal.getTime().after(end) ){
				currWeek=new Week(cal.getTime());
				if( !currWeek.equals(endWeek) ){
					weeks.add(currWeek);
				}else{
					cal.setTime(end);
					if( roundUp || (!roundUp && cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) ){
						weeks.add(endWeek);
					}
					flag=false; 
				}
			}else{ 
				flag=false; 
			}
		}while(flag);
		return weeks;
	}
	
	public List<FortNight> calculateFortNightsBetween(Date start, Date end, boolean roundUp) throws CoatlTimeStartDateException{
		List<FortNight> fortNights;
		Calendar cal;
		FortNight startFortNight;
		FortNight endFortNight;
		FortNight currFortNight;
		int maxDay;
		boolean flag=true;
		if( !startDateItsBefore(start,end) ){
			throw new CoatlTimeStartDateException(start,end);
		}
		cal=Calendar.getInstance();
		fortNights=new ArrayList<FortNight>();
		startFortNight=new FortNight(start);
		endFortNight=new FortNight(end);
		cal.setTime(start);
		if( roundUp || (!roundUp && (cal.get(Calendar.DATE)==1||cal.get(Calendar.DATE)==16)) ){
			fortNights.add(startFortNight);
		}
		do{
			if(cal.get(Calendar.DATE)<16){
				cal.set(Calendar.DATE,16);
				maxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			}else{
				cal.add(Calendar.MONTH,1);
				cal.set(Calendar.DATE,1);
				maxDay=15;
			}
			if( !cal.getTime().after(end) ){
				currFortNight=new FortNight(cal.getTime());
				if( !currFortNight.equals(endFortNight) ){
					fortNights.add(currFortNight);
				}else{
					cal.setTime(end);					
					if( roundUp || (!roundUp && cal.get(Calendar.DATE)==maxDay) ){
						fortNights.add(endFortNight);
					}
					flag=false; 
				}
			}else{ 
				flag=false; 
			}
		}while(flag);
		return fortNights;
	}
	
	public List<Month> calculateMonthsBetween(Date start, Date end, boolean roundUp) throws CoatlTimeStartDateException{
		List<Month> months;
		Calendar cal;
		Month startMonth;
		Month endMonth;
		Month currMonth;
		boolean flag=true;
		if( !startDateItsBefore(start,end) ){
			throw new CoatlTimeStartDateException(start,end);
		}
		cal=Calendar.getInstance();
		months=new ArrayList<Month>();
		startMonth=new Month(start);
		endMonth=new Month(end);
		cal.setTime(start);
		if( roundUp || (!roundUp && cal.get(Calendar.DATE)==1) ){
			months.add(startMonth);
		}
		do{
			cal.add(Calendar.MONTH,1);
			if( !cal.getTime().after(end) ){
				currMonth=new Month(cal.getTime());
				if( !currMonth.equals(endMonth) ){
					months.add(currMonth);
				}else{
					cal.setTime(end);					
					if( roundUp || (!roundUp && cal.get(Calendar.DATE)==cal.getActualMaximum(Calendar.DAY_OF_MONTH)) ){
						months.add(endMonth);
					}
					flag=false; 
				}
			}else{ 
				flag=false; 
			}
		}while(flag);
		return months;
	}
	
	public List<Bimester> calculateBimestersBetween(Date start, Date end, boolean roundUp, boolean dateLeadsFirstMonth) throws CoatlTimeStartDateException{
		List<Bimester> bimesters;
		Calendar cal;
		Bimester startBimester;
		Bimester currBimester;
		boolean flag=true;
		if( !startDateItsBefore(start,end) ){
			throw new CoatlTimeStartDateException(start,end);
		}
		cal=Calendar.getInstance();
		bimesters=new ArrayList<Bimester>();
		startBimester=new Bimester(start,dateLeadsFirstMonth);
		cal.setTime(start);
		if( roundUp || (!roundUp && cal.getTime().equals(startBimester.getStartDate())) ){
			bimesters.add(startBimester);
		}
		do{
			cal.add(Calendar.MONTH,2);
			if( !cal.getTime().after(end) ){
				currBimester=new Bimester(cal.getTime(),dateLeadsFirstMonth);
				if( !currBimester.contains(end) ){
					bimesters.add(currBimester);
				}else{
					cal.setTime(end);
					if( roundUp || (!roundUp && cal.getTime().equals(currBimester.getEndDate())) ){
						bimesters.add(currBimester);
					}
					flag=false; 
				}
			}else{
				flag=false; 
			}
		}while(flag);
		return bimesters;
	}
	
	public List<Trimester> calculateTrimestersBetween(Date start, Date end, boolean roundUp, boolean dateLeadsFirstMonth) throws CoatlTimeStartDateException{
		List<Trimester> trimesters;
		Calendar cal;
		Trimester startTrimester;
		Trimester currTrimester;
		boolean flag=true;
		if( !startDateItsBefore(start,end) ){
			throw new CoatlTimeStartDateException(start,end);
		}
		trimesters=new ArrayList<Trimester>();
		cal=Calendar.getInstance();
		startTrimester=new Trimester(start,dateLeadsFirstMonth);
		cal.setTime(start);
		if( roundUp || (!roundUp && cal.getTime().equals(startTrimester.getStartDate())) ){
			trimesters.add(startTrimester);
		}
		do{
			cal.add(Calendar.MONTH,3);
			if( !cal.getTime().after(end) ){
				currTrimester=new Trimester(cal.getTime(),dateLeadsFirstMonth);
				if( !currTrimester.contains(end) ){
					trimesters.add(currTrimester);
				}else{
					cal.setTime(end);
					if( roundUp || (!roundUp && cal.getTime().equals(currTrimester.getEndDate())) ){
						trimesters.add(currTrimester);
					}
					flag=false; 
				}
			}else{ 
				flag=false; 
			}
		}while(flag);
		return trimesters;
	}
	
	public List<Semester> calculateSemestersBetween(Date start, Date end, boolean roundUp, boolean dateLeadsFirstMonth) throws CoatlTimeStartDateException{
		List<Semester> semesters;
		Calendar cal;
		Semester startSemester;
		Semester currSemester;
		boolean flag=true;
		if( !startDateItsBefore(start,end) ){
			throw new CoatlTimeStartDateException(start,end);
		}
		semesters=new ArrayList<Semester>();
		cal=Calendar.getInstance();
		startSemester=new Semester(start,dateLeadsFirstMonth);
		cal.setTime(start);
		if( roundUp || (!roundUp && cal.getTime().equals(startSemester.getStartDate())) ){
			semesters.add(startSemester);
		}
		do{
			cal.add(Calendar.MONTH,6);
			if( !cal.getTime().after(end) ){
				currSemester=new Semester(cal.getTime(),dateLeadsFirstMonth);
				if( !currSemester.contains(end) ){
					semesters.add(currSemester);
				}else{
					cal.setTime(end);
					if( roundUp || (!roundUp && cal.getTime().equals(currSemester.getEndDate())) ){
						semesters.add(currSemester);
					}
					flag=false; 
				}
			}else{ 
				flag=false; 
			}
		}while(flag);
		return semesters;
	}
	
	private boolean startDateItsBefore(Date start, Date end){
		boolean before=start.before(end);
		return before;
	}
}
