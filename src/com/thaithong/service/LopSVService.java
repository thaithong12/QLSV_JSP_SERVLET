package com.thaithong.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thaithong.entities.LopSV;
import com.thaithong.repositories.LopSVRepository;

public class LopSVService {
	
	private LopSVRepository lopSVRepository;
	
	public LopSVService(Connection conn) {
		lopSVRepository = new LopSVRepository(conn);
	}
	
	public List<LopSV> getAllLopSV() {
		return lopSVRepository.getAllLopSV();
	}
	
	public LopSV findById(String id ) {
		return lopSVRepository.findLopSvById(id);
	}
	
	public boolean deleteLopSV(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return lopSVRepository.deleteLopSV(id);
	}

	public boolean insertLopSV(LopSV lopsv) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		return lopSVRepository.addLopSV(lopsv);
	}

}
