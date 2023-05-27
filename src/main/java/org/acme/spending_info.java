package org.acme;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class spending_info {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "Purchase_ID")
	private Long id;
	
	@Column(name = "User_ID")
	private String UserId;
	
	@Column(name = "Date")
	private String date;
	
	@Column(name = "Item_Details")
	private String filepath;
	
	@Column(name = "Total_Price")
	private Double total_price;
	
	
	
	public void setUser_ID(String UserId) {
		this.UserId = UserId;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setfilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	
	
	public Long get_id() {
		return id;
	}
	
	public String get_Userid() {
		return UserId;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getFile_path() {
		return filepath;
	}
	
	public Double total_price() {
		return total_price;
	}
	
	

}
