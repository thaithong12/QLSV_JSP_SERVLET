package com.thaithong.entities;

import java.util.List;
import javax.persistence.Id;

public class LopSV {
	@Id
	private String id;

	private String name;
	
	private List<SV> listSv;

	public LopSV() {
		super();
	}

	public LopSV(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public LopSV(String name, List<SV> listSv) {
		this.name = name;
		this.listSv = listSv;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<SV> getListSv() {
		return listSv;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setListSv(List<SV> listSv) {
		this.listSv = listSv;
	}
}
