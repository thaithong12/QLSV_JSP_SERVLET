package com.thaithong.service;

import java.sql.Connection;
import java.util.List;

import com.thaithong.entities.SV;
import com.thaithong.repositories.SVRepository;

public class SVService {
	private SVRepository sVRepository;
	
	public SVService(Connection conn) {
		this.sVRepository = new SVRepository(conn);
	}
	
	public List<SV> getAllSV() {
		return sVRepository.getAllSVs();
	}
	
}
