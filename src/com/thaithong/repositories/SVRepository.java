package com.thaithong.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.thaithong.entities.SV;
import com.thaithong.enums.Regions;
import com.thaithong.utils.DBUtil;

public class SVRepository {
	private Connection conn;

	public SVRepository(Connection conn) {
		this.conn = conn;
	}

	public List<SV> getAllSVs() {
		String sql = "select * from SV";

		List<SV> list = new ArrayList<SV>();

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				SV sv = new SV();

				sv.setId(rs.getString("id"));
				sv.setName(rs.getString("name"));
				sv.setAddress(rs.getString("address"));
				sv.setEmailEducation("emailEducation");
				sv.setPhoneNumber("phoneNumber");
				sv.setGender(rs.getBoolean("gender"));
				sv.setPassport(rs.getString("passport"));
				sv.setInsurrance(rs.getString("insurrance"));
				sv.setRegion(Regions.valueOf(rs.getString("region")));
				list.add(sv);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<SV> getListSVByLopSV(String id) {
		List<SV> listReturn = new ArrayList<SV>();

		String sql = "Select * from SV where lopsv_id = " + id;
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				SV sv = new SV();

				sv.setId(rs.getString("id"));
				sv.setName(rs.getString("name"));
				sv.setAddress(rs.getString("address"));
				sv.setEmailEducation("emailEducation");
				sv.setPhoneNumber("phoneNumber");
				sv.setGender(rs.getBoolean("gender"));
				sv.setPassport(rs.getString("passport"));
				sv.setInsurrance(rs.getString("insurrance"));
				sv.setRegion(Regions.valueOf(rs.getString("region")));
				listReturn.add(sv);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listReturn;
	}

	public SV getSvById(String id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			SV sv = em.find(SV.class, id);
			return sv;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return null;
	}

}
