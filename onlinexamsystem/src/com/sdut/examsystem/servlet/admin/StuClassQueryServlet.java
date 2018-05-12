package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.service.admin.StuClassService;
@WebServlet("/stuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet {
	StuClassService stu=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//System.out.println("123");
		List<Map<String, Object>> list=stu.findAll();
		req.setAttribute("scList", list);
		req.getRequestDispatcher("/manager/stuclassmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		//System.out.println("456");
	}

}
