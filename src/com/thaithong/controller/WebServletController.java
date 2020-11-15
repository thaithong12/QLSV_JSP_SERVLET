package com.thaithong.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thaithong.entities.LopSV;
import com.thaithong.entities.SV;
import com.thaithong.service.LopSVService;
import com.thaithong.service.SVService;
import com.thaithong.utils.ConnectionDB;

@WebServlet("/")
public class WebServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SVService serviceSV;
	
	private LopSVService lopSVService;
	
	private Connection connection;

	public WebServletController()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
		connection = ConnectionDB.openConnection();
		serviceSV = new SVService(connection);
		lopSVService = new LopSVService(connection);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/sv": 
				listAllSV(request, response);
				break;
			case "/sv/new":
				showFormAddSV(request, response);
				break;
			case "/sv/insert":
				insertSV(request, response);
				break;
			case "/sv/edit":
				editSV(request, response);
			case "/sv/delete":
				deleteSV(request, response);
			case "/lopsv": 
				listAllLopSV(request, response);
				break;
			case "/lopsv/new":
				showFormAddLopSV(request, response);
				break;
			case "/lopsv/insert":
				insertLopSV(request, response);
				break;
			case "/lopsv/edit":
				editLopSV(request, response);
			case "/lopsv/delete":
				deleteLopSV(request, response);	
			case "/lopsv/details":
				lopsvDetails(request, response);	
			default:
				userManual(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void lopsvDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		List<SV> data = serviceSV.getAllSV().stream().filter(item_-> item_.getLopsv_id().equals(id)).collect(Collectors.toList());
		request.setAttribute("svs", data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/qlsv.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteLopSV(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {
		String id = request.getParameter("id");
		lopSVService.deleteLopSV(id);
		response.sendRedirect("/lopsv");
	}

	private void editLopSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		LopSV lopsv = lopSVService.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/form-lopsv.jsp");
		if(null != lopsv) request.setAttribute("lopsv", lopsv);
		request.setAttribute("action", "edit");
		dispatcher.forward(request, response);
	}

	private void insertLopSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		if (id.equals("") || name.equals("")) {
			request.setAttribute("errs", "Insert Err");
			showFormAddLopSV(request, response);
		}
		LopSV lopsv = new LopSV(id, name);
		if (lopSVService.insertLopSV(lopsv)) {
			response.sendRedirect("/lopsv");
		} else {
			request.setAttribute("errs", "Insert Err");
			showFormAddLopSV(request, response);	
		}
	}

	private void showFormAddLopSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/form-lopsv.jsp");
		request.setAttribute("lopsvs", lopSVService.getAllLopSV());
		dispatcher.forward(request, response);
	}

	private void listAllLopSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LopSV> lopSVs = lopSVService.getAllLopSV();
		request.setAttribute("lopsvs", lopSVs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/qllopsv.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void userManual(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user-manual.jsp");
		dispatcher.forward(request, response);
	}

	private void listAllSV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SV> data = serviceSV.getAllSV();
		request.setAttribute("svs", data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/qlsv.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String id = request.getParameter("id");
		serviceSV.deleteSv(id);
		response.sendRedirect("/sv");
	}

	private void editSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String id = request.getParameter("id");
		SV sv = serviceSV.findOne(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/form-sv.jsp");
		if(null != sv) request.setAttribute("sv", sv);
		request.setAttribute("action", "edit");
		request.setAttribute("lopsvs", lopSVService.getAllLopSV());
		dispatcher.forward(request, response);
	}

	private void insertSV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address= request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String lopSv = request.getParameter("grade");
		if (id.equals("") || name.equals("")) {
			request.setAttribute("errs", "Insert Err");
			showFormAddSV(request, response);
		}
		SV sv = new SV(id, name, address, phone, email, lopSv);
		if (serviceSV.insertSV(sv)) {
			response.sendRedirect("/sv");
		} else {
			request.setAttribute("errs", "Insert Err");
			showFormAddSV(request, response);	
		}
	}

	private void showFormAddSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/form-sv.jsp");
		request.setAttribute("lopsvs", lopSVService.getAllLopSV());
		dispatcher.forward(request, response);
	}
}
