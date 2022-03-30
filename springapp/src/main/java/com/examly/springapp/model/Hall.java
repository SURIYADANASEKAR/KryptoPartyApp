package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hall")
public class Hall {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String eventdate;
	private String hallprice;
	private String halltype;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEventdate() {
		return eventdate;
	}
	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
	}
	public String getHallprice() {
		return hallprice;
	}
	public void setHallprice(String hallprice) {
		this.hallprice = hallprice;
	}
	public String getHalltype() {
		return halltype;
	}
	public void setHalltype(String halltype) {
		this.halltype = halltype;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	


}

