package org.acme;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class calendar {
 
  private String year;
  private String month;
  private String monthname;
  private String week;
  private String day;
  private String hours;
  private String minutes;
  private String seconds;
  
  
  
  public void refreshDate() {
	  LocalDate date = LocalDate.now();
	  WeekFields usWeekFields = WeekFields.of(Locale.US);
	  this.year = String.valueOf(date.getYear());
	  this.month = String.valueOf(date.getMonthValue());
	  this.monthname = String.valueOf(date.getMonth());
	  if(date.getMonth().getValue()<10) {
		  this.monthname="0"+String.valueOf(date.getMonth());		  
	  }
	  this.week ="0"+String.valueOf(date.get(usWeekFields.weekOfMonth()));
	  usWeekFields = null;
	  this.day = String.valueOf(date.getDayOfMonth());
	  if(this.da)
	  LocalTime locale = LocalTime.now();
	  this.hours = String.valueOf(locale.getHour());
	  this.minutes = String.valueOf(locale.getMinute());
	  this.seconds = String.valueOf(locale.getSecond());
	  
  }
    public String getFullDate() {
    	String temp = this.year+":"+this.month+":"+this.week+":"+this.day+":"+this.hours+":"+this.minutes+":"+this.seconds;
    	return temp;
    }
    
    public String getDate() {
    	String temp = this.day+":"+this.week+":"+this.month+":"+this.year;
    	return temp;
    }
    
   
    public String getWeekofMonth() {
    	String temp = this.week+":"+this.month+":"+this.year;
    	return temp;
    }
    
    
    
    public String getMonthOfYear() {
    	String temp = this.month+":"+this.year;
    	return temp;
    }
    public String getMonthname() {
    	return this.monthname;
    }
    public String getYear() {
	    return this.year;
    }
    public String getMonth() {
    	return this.month;
    }
    public String getDay() {
    	return this.day;
    }
    public String getWeek() {
    	return this.week;
    }
    public String getHour() {
    	return this.hours;
    }
    public String getMinutes() {
    	return this.minutes;
    }
    public String getSeconds() {
    	return this.seconds;
    }
}
