package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class AddStudengServlet1 extends HttpServlet { //表示层后端

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		Student student = new Student(sno,name,age,address);
		//采用多态的形式，右边实现类，左边改为接口
		IStudentService studentservice = new StudentServiceImpl();
		boolean result = studentservice.addstudent(student);
		/*
		 * out request response session application 常见的jsp内置对象0
		 * out : 在servlet中通过 PrintWriter out =response.getWriter(); 拿
		 * session: request.getsession();
		 * application: request.getServletContext();
		 * 
		 * */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();//servlet如果要用out来页面显示就要先设置响应编码
		/*
		if(result) {
			//out.print("增加成功！");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("增加失败！");
		}
		*/
		if(!result) {
			request.setAttribute("error", "addError");
		}else {
			request.setAttribute("error", "noaddError");
		}
		request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
