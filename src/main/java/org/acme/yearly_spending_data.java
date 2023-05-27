package org.acme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class yearly_spending_data {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "user_id")
  private String user_id;
  
  @Column(name = "year")
  private String year;
  
  @Column(name = "year_spent")
  private Double year_spent;

  public String getUser_id() {
	  return user_id;
  }

  public void setUser_id(String user_id2) {
	  this.user_id = user_id2;
  } 

  public String getYear() {
	  return year;
  }

  public void setYear(String current_year) {
	  this.year = current_year;
  }

  public Double getYear_spent() {
	  return year_spent;
  }

  public void setYear_spent(Double year_spent) {
	  this.year_spent = year_spent;
  }
  
  }
