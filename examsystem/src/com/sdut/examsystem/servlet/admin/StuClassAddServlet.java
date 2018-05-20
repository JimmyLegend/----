package com.sdut.examsystem.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.StuClass;
import com.sdut.examsystem.service.admin.StuClassService;
import com.sdut.examsystem.util.Department;
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {
	StuClassService scs=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setAttribute("depList",Department.values());
		req.getRequestDispatcher("/manager/stuclassadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		String clanum=req.getParameter("clanum");
		String claname=req.getParameter("claname");
		//System.out.println(claname);
		String depInfo=req.getParameter("depInfo");
		int clanum_int=Integer.valueOf(clanum).intValue();
		StuClass sc=new StuClass();
		sc.setId(clanum_int);
		sc.setName(claname);
		sc.setDeptName(depInfo);
		scs.addstuClass(sc);
		resp.sendRedirect(req.getContextPath()+"/stuClassQueryServlet");
//		List<Map<String, Object>> list=scs.findAll();
//		req.setAttribute("scList", list);
//		req.getRequestDispatcher("/manager/stuclassmanage.jsp").forward(req, resp);
	}

}
