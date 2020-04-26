package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

public class DeleteStudentServlet extends HttpServlet {
	
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		IStudentService service = new StudentServiceImpl();
		 boolean flag = service.deleteStudentBySno(no);
		 response.setContentType("text/html; charset=UTF-8");
		 response.setCharacterEncoding("utf-8");
		 if(flag) {
			 //response.getWriter().println("删除成功！");
			 response.sendRedirect("QueryAllStudentServlet");//重新查询，刷新表单
		 }else {
			 response.getWriter().println("删除失败！");
		 }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
