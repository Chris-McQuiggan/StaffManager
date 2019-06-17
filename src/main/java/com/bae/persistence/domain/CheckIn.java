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
	private Double hours;

	public CheckIn() {

	}

	public CheckIn(int logID, String timeIn, String timeOut, Double hours) {
		super();
		this.logID = logID;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.hours = hours;
	}

	public CheckIn(int logID, String timeIn) {
		super();
		this.logID = logID;
		this.timeIn = timeIn;
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public int getLogID() {
		return logID;
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

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

}
