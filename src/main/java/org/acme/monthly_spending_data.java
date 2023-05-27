package org.acme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class monthly_spending_data {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "user_id")
   private String user_id;
   
   @Column(name = "month_of_year")
   private String month_of_year;
   
   @Column(name = "month_spent")
   private Double month_spent;

   public String getUser_id() {
	  return user_id;
  }

   public void setUser_id(String user_id2) {
	   this.user_id = user_id2;
   }

   public String getMonth_of_year() {
	   return month_of_year;
   }

   public void setMonth_of_year(String month_of_year) {
	   this.month_of_year = month_of_year;
   }

   public Double getMonth_spent() {
	   return month_spent;
   }

   public void setMonth_spent(Double month_spent) {
	   this.month_spent = month_spent;
   }
         
  }
