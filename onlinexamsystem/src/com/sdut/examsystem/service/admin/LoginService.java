package com.sdut.examsystem.service.admin;

import java.util.ArrayList;
import java.util.List;

import com.sdut.examsystem.dao.admin.LoginDao;
import com.sdut.examsystem.po.Student;
import com.sdut.examsystem.po.Teacher;
import com.sdut.examsystem.service.ILoginService;

public class LoginService implements ILoginService {
	LoginDao ld=new LoginDao();
	@Override
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		return ld.canLogin(t);
	}

	@Override
	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		return ld.canLogin(s);
	}

}
