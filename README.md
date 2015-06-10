# TimeInterval
TimeInterval its a java proyect to work with time intervals such weeks, fortnights, months, bimesters, trimesters and semesters.

The main intent this project has ir to provide some methods to work with intervals of time and its internal intervals.

For example if you want to know how many weeks there are between two dates, you can get it with this, but no just that, moreover, you can get a list of weeks, so this way you can use it to some proccess which need every week to schedule or planning meaning or whatever else you need.

The core its the class TimeUnit, from that one there are inherited the objects Week, FortNight (very useful in mexico for salaries), Month, Bimester, Trimester and Semester)

Every unit of time has a strat date and end date and a unit name** and description** (**For this version, harcoded in spanish)

And for work with coleection of the intervals use the methods in class CalculateIntervals

For example to get a list of weeks between two given dates the method is:

List<Week> calculateWeeksBetween(Date start, Date end, boolean roundUp) throws CoatlTimeStartDateException

Where you pass the star and end date.

The roundUp means if true to include first and last weeks when the date (begining or ending) its not exactly at the start or end of the week.

The same logic applies to get fortnights and months

calculateFortNightsBetween

calculateMonthsBetween


For bimesters, trimester and semesters:

List<Bimester> calculateBimestersBetween(Date start, Date end, boolean roundUp, boolean dateLeadsFirstMonth)

There is ona extra parameter: dateLeadsFirstMonth

This parameter means if true the month corresponding to passed start date will be used as the 1st month for the period, if false then the periods will be calculated taking january as base. 

For example if you want a bimester for the date 2015-02-03, if dateLeadsFirstMonth its true the bimesters will be jan-feb, if false the bimester will be feb-mar

At last this methids can throw a CoatlTimeStartDateExceptionwhich means the end date is before start date 
