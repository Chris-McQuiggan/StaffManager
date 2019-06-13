package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int staffID;
	private String firstName;
	private String lastName;
	private String email;
	private String jobRole;
	private String payTier;

	public Staff() {

	}

	public Staff(int staffID, String firstName, String lastName, String email, String jobRole, String payTier) {
		super();
		this.staffID = staffID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.jobRole = jobRole;
		this.payTier = payTier;
	}

	public int getStaffID() {
		return staffID;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getPayTier() {
		return payTier;
	}

	public void setPayTier(String payTier) {
		this.payTier = payTier;
	}
}
