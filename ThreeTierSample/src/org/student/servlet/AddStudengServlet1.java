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


public class AddStudengServlet1 extends HttpServlet { //��ʾ����

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		Student student = new Student(sno,name,age,address);
		//���ö�̬����ʽ���ұ�ʵ���࣬��߸�Ϊ�ӿ�
		IStudentService studentservice = new StudentServiceImpl();
		boolean result = studentservice.addstudent(student);
		/*
		 * out request response session application ������jsp���ö���0
		 * out : ��servlet��ͨ�� PrintWriter out =response.getWriter(); ��
		 * session: request.getsession();
		 * application: request.getServletContext();
		 * 
		 * */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();//servlet���Ҫ��out��ҳ����ʾ��Ҫ��������Ӧ����
		/*
		if(result) {
			//out.print("���ӳɹ���");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			out.print("����ʧ�ܣ�");
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
