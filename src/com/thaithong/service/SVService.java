package com.thaithong.service;

import java.sql.Connection;
import java.sql.SQLException;
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
	
	public boolean insertSV(SV sv ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return sVRepository.addSV(sv);
	}
	
	public boolean deleteSv(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return sVRepository.deleteSv(id);
	}
	
	public SV findOne(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {	
		return sVRepository.findById(id);
	}
}
