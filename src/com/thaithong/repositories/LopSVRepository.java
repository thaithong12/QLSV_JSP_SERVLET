package com.thaithong.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.thaithong.entities.LopSV;

public class LopSVRepository {
	private Connection conn;
	
	public LopSVRepository(Connection conn) {
		this.conn = conn;
	}
	
	public List<LopSV> getAllLopSV() {
		String sql = "select * from LopSV";

		List<LopSV> list = new ArrayList<LopSV>();

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				LopSV sv = new LopSV();

				sv.setId(rs.getString("id"));
				sv.setName(rs.getString("name"));
				
				list.add(sv);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
