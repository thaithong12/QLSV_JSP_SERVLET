package com.thaithong.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thaithong.entities.SV;
import com.thaithong.service.SVService;
import com.thaithong.utils.ConnectionDB;

public class WebServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SVService serviceSV;
	
	private Connection connection;
	
    public WebServletController() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        super();
        connection = ConnectionDB.openConnection();
        serviceSV = new SVService(connection);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/new":
				showFormAddSV(request, response);
				break;
			case "/insert":
				insertSV(request, response);
				break;
			case "/edit": 
				editSV(request, response);
			case  "/delete": 
				deleteSV(request, response);
			default:
				listAllSV(request,response);
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	private void listAllSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SV> data =  serviceSV.getAllSV();
		request.setAttribute("svs", data );
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listData.jsp");
        dispatcher.forward(request, response);
        
	}

	private void deleteSV(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void editSV(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void insertSV(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void showFormAddSV(HttpServletRequest request, HttpServletResponse response) {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
