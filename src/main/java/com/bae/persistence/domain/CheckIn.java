package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckIn {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int logID;
	private String timeIn;
	private String timeOut;
	private String hours;

	public CheckIn() {

	}

	public CheckIn(int logID, String timeIn, String timeOut, String hours) {
		super();
		this.logID = logID;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.hours = hours;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

}
