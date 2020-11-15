package com.thaithong.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection openConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();// nap driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsv?" + "user=root&password=thuhai,./");
		return con;
	}
}
