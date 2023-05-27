package org.acme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class daily_spending_data {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "daily_spent")
	private Double daily_spent;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id2) {
		this.user_id = user_id2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getDaily_spent() {
		return daily_spent;
	}

	public void setDaily_spent(Double daily_spent) {
		this.daily_spent = daily_spent;
	}
}
