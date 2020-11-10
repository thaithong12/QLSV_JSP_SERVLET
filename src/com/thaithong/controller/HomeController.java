package com.thaithong.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thaithong.entities.SV;
import com.thaithong.service.SVService;
import com.thaithong.utils.ConnectionDB;


@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SVService serviceSV;
	
	private Connection connection;
    public HomeController() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        super();
        connection = ConnectionDB.openConnection();
        serviceSV = new SVService(connection);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SV> svs = serviceSV.getAllSV();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
