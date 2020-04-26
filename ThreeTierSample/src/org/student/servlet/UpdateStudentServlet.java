package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class UpdateStudentServlet extends HttpServlet {

       
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt( request.getParameter("sno"));
		
		String name = request.getParameter("sname");
		int age = Integer.parseInt( request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(name,age,address);
		IStudentService service = new StudentServiceImpl();
		boolean flag = service.updateStudentBySno(no, student);
		 response.setContentType("text/html; charset=UTF-8");
		 response.setCharacterEncoding("utf-8");
		if(flag) {
			//response.getWriter().println("���³ɹ���");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			response.getWriter().println("����ʧ�ܣ�");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
