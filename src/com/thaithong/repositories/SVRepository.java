package com.thaithong.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thaithong.entities.SV;
import com.thaithong.service.LopSVService;
import com.thaithong.utils.ConnectionDB;

public class SVRepository {
	private Connection conn;

	private LopSVService lopSVService;

	public SVRepository(Connection conn) {
		this.conn = conn;
		lopSVService = new LopSVService(conn);
	}

	public List<SV> getAllSVs() {
		String sql = "select * from SV";

		List<SV> list = new ArrayList<SV>();

		try (Connection con = ConnectionDB.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				SV sv = new SV();

				sv.setId(rs.getString("id"));
				sv.setName(rs.getString("name"));
				sv.setAddress(rs.getString("address"));
				sv.setEmailEducation(rs.getString("email_education"));
				sv.setPhoneNumber(rs.getString("phone_number"));
				sv.setLopsv_id(rs.getString("lopsv_id"));
				sv.setLopSV(lopSVService.findById(rs.getString("lopsv_id")));
				list.add(sv);
				conn.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<SV> getListSVByLopSV(String id) {
		List<SV> listReturn = new ArrayList<SV>();

		String sql = "Select * from SV where lopsv_id = " + id;
		try (Connection con = ConnectionDB.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				SV sv = new SV();

				sv.setId(rs.getString("id"));
				sv.setName(rs.getString("name"));
				sv.setAddress(rs.getString("address"));
				sv.setEmailEducation(rs.getString("email_education"));
				sv.setPhoneNumber(rs.getString("phone_number"));
				sv.setLopsv_id(rs.getString("lopsv_id"));
				listReturn.add(sv);
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listReturn;
	}

	public boolean deleteSv(String id)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		boolean chẹck = false;
		String sql = "delete from sv where id = ?";
		Connection con = ConnectionDB.openConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.execute();
			chẹck = true;
			con.close();
		} catch (Exception e) {
			chẹck = false;
			System.out.println(e.getMessage());
		}
		return chẹck;
	}

	public boolean addSV(SV sv)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		boolean check = false;
		List<SV> listData = getAllSVs();
		SV svExist = listData.stream().filter(item -> sv.getId().equals(item.getId())).findFirst().orElse(null);
		Connection con = ConnectionDB.openConnection();
		if (null == svExist) {
			String sql = "insert into sv values(?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sv.getId());
				pstmt.setString(2, sv.getName());
				pstmt.setString(3, sv.getAddress());
				pstmt.setString(4, sv.getPhoneNumber());
				pstmt.setString(5, sv.getEmailEducation());
				pstmt.setString(6, sv.getLopsv_id());
				pstmt.executeUpdate();
				check = true;
				con.close();
			} catch (Exception e) {
				check = false;
				System.out.println(e.getMessage());
			}
		} else {
			String sql = "update sv set name = ? , address = ? ,phone_number = ? , email_education = ? , lopsv_id = ? "
					+ "where id = ? ,";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(6, sv.getId());
				pstmt.setString(1, sv.getName());
				pstmt.setString(2, sv.getAddress());
				pstmt.setString(3, sv.getPhoneNumber());
				pstmt.setString(4, sv.getEmailEducation());
				pstmt.setString(5, sv.getLopsv_id());
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

	public SV findById(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from sv where id = ?";
		Connection con = ConnectionDB.openConnection();
		SV sv = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				sv = new SV();
				sv.setId(rs.getString("id"));
				sv.setName(rs.getString("name"));
				sv.setAddress(rs.getString("address"));
				sv.setEmailEducation(rs.getString("email_education"));
				sv.setPhoneNumber(rs.getString("phone_number"));
				sv.setLopsv_id(rs.getString("lopsv_id"));
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}
		return sv;
	}

}
