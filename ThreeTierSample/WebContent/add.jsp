<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
</script>
<script type="text/javascript">
	function check()//如果return true 表单正常提交，return false表单终止提交
	{
		var sno = $("#sno").val();
		var sname = $("#sname").val();
		var sage = $("#sage").val();
		var saddress = $("#saddress").val();
		if(sno<0||sno>101){
			alert("学号有误 学号必须是1-100")
			return false;
		}
		if(sname.length<=0||sname.length>5){
			alert("姓名有误 姓名必须是1-5")
			return false;
		}
		
		return true;
	}

	$(document).ready(function() {
	})


</script>
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="AddStudengServlet1" method="post" onsubmit="return check()">
			学号:  <input type="text"  name="sno" id="sno"><br/>
			姓名：<input type="text"  name="sname" id="sname"><br/>
			年龄：<input type="text"  name="sage" id="sage"><br/>
			地址：<input type="text"  name="saddress" id="saddress"><br/>
			<input type="submit"  value="新增学生">
		</form>
</body>
</html>