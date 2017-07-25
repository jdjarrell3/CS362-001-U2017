 
package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	// Covered goals for unit test test01():
	// The goal of the test01 is to call the public method getApptRange with the exact objects too cover the following targets:
	// Switch Statement in the private method getNextApptOccurrence
	// in particular case Appt.RECUR_BY_MONTHLY
	 public void test01()  throws Throwable  {
		 TimeTable t=new TimeTable();


		 //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
			//get todays date
	    	Calendar rightnow = Calendar.getInstance();
	    	//current month/year/date is today
	    	int thisMonth = rightnow.get(Calendar.MONTH)+1;
			int thisYear = rightnow.get(Calendar.YEAR);
			int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay;  	//11
			 int startMonth=thisMonth; 	//4
			 int startYear=thisYear; 	//2017
        String title="Birthday Party";
        String description="This is my birthday party.";
        // Create a valid appointment!
        Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        /** Collection of all of the appointments for the calendar day */	
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);

//	Adding a second appointment to the good test
	startDay=thisDay-1;
	title="Birthday Party Numero Tres";
	description="This is my other friend's birthday party.";
        Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	appts.add(appt2);
//	Adding a third appointment to the good test
	startDay=thisDay+1;
	title="Birthday Party Numero four";
	description="This is another friend's birthday party.";
        Appt appt3 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	appts.add(appt3);
//	Adding a fourth appointment to the good test
	startDay=thisDay;
	title="Birthday Party Numero five";
	description="This is yet another friend's birthday party.";
        Appt appt4 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	appts.add(appt4);

        //Change the  default recurring information in the object appt using setRecurrence method in the Appt class 
        int[] recurringDays =  new int[0];
       appt.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 0, 1);
		//get a list of appointments for one day that are occurred between today and tomorrow!
        GregorianCalendar firstDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
        //Create an identical object for the firstDay
		GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
		//Increase today day to 1
		lastDay.add(Calendar.DAY_OF_MONTH,1);
       try {
    	  // Retrieves a range of appointments between two dates (i.e., today and tomorrow).
           t.getApptRange(appts, firstDay, lastDay);
       }
       catch( NullPointerException e)
        {

        }

	 }

//	Copy of Test01, but making minor changes to try to cause failures
	 public void test02()  throws Throwable  {
		 TimeTable t=new TimeTable();


		 //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
			//get todays date
	    	Calendar rightnow = Calendar.getInstance();
	    	//current month/year/date is today
	    	int thisMonth = rightnow.get(Calendar.MONTH)+1;
			int thisYear = rightnow.get(Calendar.YEAR);
			int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=16;
			 int startMinute=30;
			 int startDay=thisDay;  	//11
			 int startMonth=thisMonth; 	//4
			 int startYear=thisYear; 	//2017
        String title="Birthday Party Numero Dos";
        String description="This is my friend's birthday party.";
        // Create a valid appointment!
        Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        /** Collection of all of the appointments for the calendar day */	
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);

//	Adding a second appointment to the bad test
	startDay=thisDay-1;
	title="Birthday Party Numero Tres";
	description="This is my other friend's birthday party.";
        Appt appt2 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	appts.add(appt2);
//	Adding a third appointment to the bad test
	startDay=thisDay+1;
	title="Birthday Party Numero four";
	description="This is another friend's birthday party.";
        Appt appt3 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	appts.add(appt3);
//	Adding a fourth appointment to the bad test
	startDay=thisDay;
	startMonth=15;
	title="Birthday Party Numero five";
	description="This is yet another friend's birthday party.";
        Appt appt4 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
	appts.add(appt4);

        //Change the  default recurring information in the object appt using setRecurrence method in the Appt class 
        int[] recurringDays =  new int[0];
       appt.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 0, 1);
		//get a list of appointments for one day that are occurred between today and tomorrow!
        GregorianCalendar firstDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
        //Create an identical object for the firstDay
		GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
		//Increase today day to 1
		lastDay.add(Calendar.DAY_OF_MONTH,-1);
       try {
    	  // Retrieves a range of appointments between two dates (i.e., today and tomorrow).
           t.getApptRange(appts, firstDay, lastDay);
       }
       catch( NullPointerException e)
        {

        }

	 }

//	Clone of test01; trying to cause errors by not appts in the list
	 public void test03()  throws Throwable  {
		 TimeTable t=new TimeTable();


		 //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
			//get todays date
	    	Calendar rightnow = Calendar.getInstance();
	    	//current month/year/date is today
	    	int thisMonth = rightnow.get(Calendar.MONTH)+1;
			int thisYear = rightnow.get(Calendar.YEAR);
			int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay;  	//11
			 int startMonth=thisMonth; 	//4
			 int startYear=thisYear; 	//2017
        String title="Birthday Party";
        String description="This is my birthday party.";
        // Create a valid appointment!
        Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        /** Collection of all of the appointments for the calendar day */	
        LinkedList<Appt> appts = new LinkedList<Appt>();
//        appts.add(appt);

        //Change the  default recurring information in the object appt using setRecurrence method in the Appt class 
        int[] recurringDays =  new int[0];
       appt.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 0, 1);
		//get a list of appointments for one day that are occurred between today and tomorrow!
        GregorianCalendar firstDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
        //Create an identical object for the firstDay
		GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
		//Increase today day to 1
		lastDay.add(Calendar.DAY_OF_MONTH,1);
       try {
    	  // Retrieves a range of appointments between two dates (i.e., today and tomorrow).
           t.getApptRange(appts, firstDay, lastDay);
       }
       catch( NullPointerException e)
        {

        }

	 }

}
