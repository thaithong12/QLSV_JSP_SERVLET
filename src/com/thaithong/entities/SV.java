package com.thaithong.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thaithong.enums.Regions;

@Entity
@Table(name = "sv")
public class SV {
	@Id
	private String id;

	private String name;

	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	private boolean gender;

	private String passport;

	@Column(name = "email_education")
	private String emailEducation;

	private String insurrance;
	
	private Regions region ;

	@ManyToOne
	@JoinColumn(name = "lopsv_id")
	private LopSV lopSV;

	public SV() {
		super();
	}

	public String getId() { 
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isGender() {
		return gender;
	}

	public String getPassport() {
		return passport;
	}

	public String getEmailEducation() {
		return emailEducation;
	}

	public String getInsurrance() {
		return insurrance;
	}

	public Regions getRegion() {
		return region;
	}

	public LopSV getLopSV() {
		return lopSV;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public void setEmailEducation(String emailEducation) {
		this.emailEducation = emailEducation;
	}

	public void setInsurrance(String insurrance) {
		this.insurrance = insurrance;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

	public void setLopSV(LopSV lopSV) {
		this.lopSV = lopSV;
	}

	public SV(String name, String address, String phoneNumber, boolean gender, String passport, String emailEducation,
			String insurrance, Regions region, LopSV lopSV) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.passport = passport;
		this.emailEducation = emailEducation;
		this.insurrance = insurrance;
		this.region = region;
		this.lopSV = lopSV;
	}
}
