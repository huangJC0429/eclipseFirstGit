package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

//通用的数据库操作方法，增删改查 任何系统都可以直接掉这个程序，不止学生，啥都行
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/hjc_mysql";
	private static final String USER = "root";
	private static final String PASSWORD = "hjc290018";
    public static Connection connection = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    
    
    public static int getTotalCount(String sql) {//查询数据总数
    	try {
		    pstmt = creatPreparedStatement(sql, null);
		    rs = pstmt.executeQuery();
		    if(rs.next()) {
		   return rs.getInt(1);
		    }
		    return 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
		
    }
    public static Connection getconnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
    public static PreparedStatement creatPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException{
    	 pstmt = getconnection().prepareStatement(sql);
 		 if(params!=null) {
 		 for(int i=0;i<params.length;i++) {
 		 pstmt.setObject(i+1, params[i]);
 		 }
 		 }
 		 return pstmt;
    }
		//通用的增删改
	public static boolean executeUpdate(String sql,Object[] params) {  
		try {
		//如果是更新等操作，就有很多问号，然而name age数据类型不一样，所以用万能的Object数组 Object[] obs = {name,age,..}
		//String sql = "delete from student where sno=?";
			creatPreparedStatement(sql, params);
				 int count = pstmt.executeUpdate();
		 if(count>0) {
			 return true;
		 }else {
			 return false;
		 }
		
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
			if(pstmt!=null) pstmt.close();
			if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
		//通用的查
	public static ResultSet executeQuery(String sql , Object[] params) { 
		//List<Student> students = new ArrayList<>();//有很多学生 所以用集合
		//Student student = null;
		try {
		//String sql = "select * from student ";
		 creatPreparedStatement(sql, params);
		 rs = pstmt.executeQuery();
		 return rs;
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}//后面的异常后面处理
	}
}
