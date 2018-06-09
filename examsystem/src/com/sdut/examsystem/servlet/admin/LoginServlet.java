package com.sdut.examsystem.servlet.admin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.admin.LoginService;
import com.sdut.examsystem.util.DBDataSource;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	static String adminUser = null;
	static String adminPassword = null;
	static{
		Properties config = new Properties();
		try {
			config.load(new FileReader(
					DBDataSource.class.getClassLoader().
					getResource("db.properties").getPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		adminUser = config.getProperty("adminUser");
		adminPassword = config.getProperty("adminPassword");
		
	}
	LoginService ls=new LoginService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		//System.out.println(123);

		//System.out.println("post");
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		if(role.equals("admin"))
		{
			if(adminUser.equals(name)&&adminPassword.equals(password)){
				req.getSession().setAttribute("admin", name);
				req.getRequestDispatcher("manager/mindex.jsp").forward(req, resp);
			}
			else{
				resp.sendRedirect("login.jsp");
			}
			
		}
		else if(role.equals("teacher")){
			//System.out.println(1234);
			Teacher teacher=new Teacher();
			teacher.setName(name);
			teacher.setPassword(password);
			//teacher.setRole(Integer.parseInt(role));
			Teacher teach=ls.canLogin(teacher);
			if(teach!=null){
				req.getSession().setAttribute("teacher", teach);
//				System.out.println(teach.getId());
//				System.out.println(teach.getName()+"123");
				req.getRequestDispatcher("teacher/tindex.jsp").forward(req, resp);
			}
			else{
				resp.sendRedirect("login.jsp");
			}
		}
		else{
			Student student=new Student();
			student.setName(name);
			student.setPwd(password);
			Student stud=ls.canLogin(student);
			if(stud!=null){
				req.getSession().setAttribute("student", stud);
				req.getRequestDispatcher("/student/index.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("login.jsp");
			}
			
		}
	}
	

}
