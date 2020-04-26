package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class QueryStudentBySnoServlet extends HttpServlet {

       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		IStudentService service = new StudentServiceImpl();
		Student student = service.queryStudentBySno(no);
		System.out.println(student);
		//将此人的信息通过前台JSP显示：studentInfo.jsp
		request.setAttribute("Student",student );
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
