<%@page import="org.student.entity.Page"%>
<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("tr:odd").css("background-color","lightgray");
	})


</script>
</head>

<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>

			<%
				String error = (String)request.getAttribute("error");
			if(error!=null){
				if(error.equals("addError")){
					out.print("增加失败！");
				}else if(error.equals("noaddError")){
					out.print("增加成功！");
				}
			}
			
			%>
			<table border="1">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>操作</th>
				</tr>
			<%
				//获取request域中的数据 ,数据到达时object类型所以要转 
				Page p = (Page)request.getAttribute("p");
			    for(Student student:p.getStudents()){
					%>
						<tr>
						<td><a href="QueryStudentBySnoServlet?sno=<%= student.getSno() %>"><%= student.getSno() %></a></td>
						<td><%= student.getSname() %></td>
						<td><%= student.getSage() %></td>
						<td><a href="DeleteStudentServlet?sno=<%=student.getSno() %>">删除</a></td>
						</tr>
					
					<%
					
				}
			
			
			%>
			
			
			
			</table>
			<a href="add.jsp">新增学生</a><br/>
			
			<%
				if(p.getCurrentPage()==1){
			%>		<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
					<a href="QueryStudentByPageServlet?currentPage=<%=p.getTotalPage()%>">尾页</a>
			<% 		
				}
				else if(p.getCurrentPage()==p.getTotalPage()){
		%>  <a href="QueryStudentByPageServlet?currentPage=1">首页</a>
		 	<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
		<%		
			}else{
			
			
			%>
			<a href="QueryStudentByPageServlet?currentPage=1">首页</a>
			<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
			<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
			<a href="QueryStudentByPageServlet?currentPage=<%=p.getTotalPage()%>">尾页</a>
			<%
			}
			%>
</body>
</html>