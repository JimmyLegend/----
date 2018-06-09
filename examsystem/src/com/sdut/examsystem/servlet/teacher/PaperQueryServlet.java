package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.teacher.PaperService;

@WebServlet("/PaperQueryServlet")
public class PaperQueryServlet extends HttpServlet {
	PaperService pService=new PaperService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		int testId=Integer.parseInt(request.getParameter("id"));
		List<Map<String, Object>> paper=pService.findPapersByTeaId(teacher.getId(),testId);
		//System.out.println(teacher.getId());
		request.setAttribute("papersList", paper);
		request.getRequestDispatcher("/teacher/paper.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
