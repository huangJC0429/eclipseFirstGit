package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class QueryStudentByPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Page page = new Page();
		IStudentService studentservice = new StudentServiceImpl();
		int count = studentservice.getTotalCount();
		
		String cpage =request.getParameter("currentPage");
		if(cpage==null) {
			cpage="1";
		}
		int currentPage = Integer.parseInt(cpage);
		page.setCurrentPage(currentPage);
		int pageSize = 3;
		
		int totalCount = studentservice.getTotalCount();
		page.setTotalCount(totalCount);
		page.setPageSize(pageSize);//必须先执行总数据在执行总页面大小，否则nullpointer,因为自己写的entity。
		List<Student> students = studentservice.queryStudentByPage(currentPage, pageSize);
		page.setStudents(students);
		System.out.println(students);
		System.out.println(count);
		
		request.setAttribute("p",page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
