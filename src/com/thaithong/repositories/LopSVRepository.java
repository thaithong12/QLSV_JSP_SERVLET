package com.thaithong.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thaithong.entities.LopSV;
import com.thaithong.entities.SV;
import com.thaithong.utils.ConnectionDB;

public class LopSVRepository {
	private Connection conn;
	
	public LopSVRepository(Connection conn) {
		this.conn = conn;
	}
	
	public List<LopSV> getAllLopSV() {
		String sql = "select * from LopSV";

		List<LopSV> list = new ArrayList<LopSV>();

		try (Connection con = ConnectionDB.openConnection();PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				LopSV sv = new LopSV();

				sv.setId(rs.getString("id"));
				sv.setName(rs.getString("name"));
				
				list.add(sv);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public LopSV findLopSvById(String id ) {
		List<LopSV> lopSVs = getAllLopSV();
		LopSV lopSV = null;
		if (!lopSVs.isEmpty()) {
			lopSV = lopSVs.stream().filter(item -> id.equals(item.getId())).findFirst().orElse(null);
		}
		return lopSV;
	}
	
	public boolean deleteLopSV(String id ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		boolean chẹck = false;
		String sql = "delete from lopsv where id = ?";
		String preDelete = "update sv set lopsv_id = ? where lopsv_id = ?";
		Connection con = ConnectionDB.openConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(preDelete);
			pstmt.setString(1, " ");
			pstmt.setString(2, id);
			pstmt.execute();
			
			PreparedStatement pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, id);
			pstmt2.execute();
			chẹck = true;
			con.close();
		} catch (Exception e) {
			chẹck = false;
			System.out.println(e.getMessage());
		}
		return chẹck;
	}
	
	public boolean addLopSV(LopSV sv)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		boolean check = false;
		List<LopSV> listData = getAllLopSV();
		LopSV lopsvExist = listData.stream().filter(item -> sv.getId().equals(item.getId())).findFirst().orElse(null);
		Connection con = ConnectionDB.openConnection();
		if (null == lopsvExist) {
			String sql = "insert into lopsv values(?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sv.getId());
				pstmt.setString(2, sv.getName());
				pstmt.executeUpdate();
				check = true;
				con.close();
			} catch (Exception e) {
				check = false;
				System.out.println(e.getMessage());
			}
		} else {
			String sql = "update lopsv set name = ? "
					+ "where id = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(2, sv.getId());
				pstmt.setString(1, sv.getName());
				pstmt.executeUpdate();
				check = true;
				con.close();
			} catch (Exception e) {
				check = false;
				System.out.println(e.getMessage());
			}
		}
		return check;
	}

}
