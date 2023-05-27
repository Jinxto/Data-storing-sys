package org.acme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class userPortfolio {
	
  
 
  @Id
  @Column(name = "user_id")
  private String user_id;
  
  @Column(name = "curr_year")
  private String current_year;
  
  @Column(name = "curr_year_spent")
  private Double currentYearSpent;
  
  @Column(name = "curr_month")
  private String current_month;

  @Column(name = "curr_month_spent")
  private Double currentMonthSpent;
  
  @Column(name = "curr_week")
  private String current_week;
  
  @Column(name = "curr_week_spent")
  private Double currentWeekSpent;
  
  @Column(name = "curr_day")
  private String current_day;
  
  @Column(name = "curr_day_spent")
  private Double currentDaySpent;
  
  @Column(name = "first_joined")
  private String first_joined_date;
  
  @Column(name = "last_updated")
  private String last_updated_date;
  
  
  public String getUser_id() {
	  return user_id;
  }

  public void setUser_id(String user_id) {
      this.user_id = user_id;
  }

  public String getCurrent_year() {
	  return current_year;
  }

  public void setCurrent_year(String current_year) {
	  this.current_year = current_year;
  }

  public Double getCurrentYearSpent() {
	  return currentYearSpent;
  }

  public void setCurrentYearSpent(Double currentYearSpent) {
	  this.currentYearSpent = currentYearSpent;
  }

  public String getCurrent_month() {
	  return current_month;
  }

  public void setCurrent_month(String current_month) {
	  this.current_month = current_month;
  }

  public Double getCurrentMonthSpent() {
	  return currentMonthSpent;
  }

  public void setCurrentMonthSpent(Double currentMonthSpent) {
	  this.currentMonthSpent = currentMonthSpent;
  }

  public String getCurrent_week() {
	  return current_week;
  }

  public void setCurrent_week(String current_week) {
	  this.current_week = current_week;
  }

  public Double getCurrentWeekSpent() {
	  return currentWeekSpent;
  }

  public void setCurrentWeekSpent(Double currentWeekSpent) {
	  this.currentWeekSpent = currentWeekSpent;
  }

  public String getCurrent_day() {
	  return current_day;
  }

  public void setCurrent_day(String current_day) {
	  this.current_day = current_day;
  }

  public Double getCurrentDaySpent() {
	  return currentDaySpent;
  }

  public void setCurrentDaySpent(Double currentDaySpent) {
	  this.currentDaySpent = currentDaySpent;
  }

  public String getFirst_joined_date() {
	  return first_joined_date;
  }

  public void setFirst_joined_date(String first_joined_date) {
	  this.first_joined_date = first_joined_date;
  }

  public String getLast_updated_date() {
	  return last_updated_date;
  }

  public void setLast_updated_date(String last_updated_date) {
	  this.last_updated_date = last_updated_date;
  }
  
  
 }
