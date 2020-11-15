package com.thaithong.entities;

public class SV {

	private String id;

	private String name;

	private String address;

	private String phoneNumber;

	private String emailEducation;
	
	private String lopsv_id;

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
	
	public String getEmailEducation() {
		return emailEducation;
	}

	public String getLopsv_id() {
		return lopsv_id;
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

	public void setEmailEducation(String emailEducation) {
		this.emailEducation = emailEducation;
	}

	public void setLopsv_id(String lopsv_id) {
		this.lopsv_id = lopsv_id;
	}

	public void setLopSV(LopSV lopSV) {
		this.lopSV = lopSV;
	}

	public SV(String id, String name, String address, String phoneNumber, String emailEducation,
			String lopsv_id) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailEducation = emailEducation;
		this.lopsv_id = lopsv_id;
	}
}
