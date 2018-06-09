package com.sdut.examsystem.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.dao.teacher.PapersDao;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.teacher.PaperService;
@WebServlet("/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet {
	 PaperService ps=new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		Teacher teacher=(Teacher) req.getSession().getAttribute("teacher");
		List list=ps.getPaperCompare(teacher.getId());
		req.setAttribute("paperList", list);
		req.getRequestDispatcher("/teacher/classpapers.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
