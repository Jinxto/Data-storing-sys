package org.acme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class weekly_spending_data {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "week_of_month_year")
	private String week_of_month_year;

	@Column(name = "week_spent")
	private Double week_spent;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id2) {
		this.user_id = user_id2;
	}

	public String getWeek_of_month_year() {
		return week_of_month_year;
	}

	public void setWeek_of_month_year(String week_of_month_year) {
		this.week_of_month_year = week_of_month_year;
	}

	public Double getWeek_spent() {
		return week_spent;
	}

	public void setWeek_spent(Double week_spent) {
		this.week_spent = week_spent;
	}
	
	
}
