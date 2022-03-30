package com.examly.springapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Bookconfirm")
public class Book {
	@Id
	long id;
	@JsonIgnore

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hall_id")
	Hall hall;
	double price;
	Long user_id;
	@Column(updatable = false, insertable = false)
	String added_date;
	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAdded_date() {
		return added_date;
	}

	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}

	Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public long getId() {
		return id;
	}

	public Hall getHall() {
		return hall;
	}

	

}
