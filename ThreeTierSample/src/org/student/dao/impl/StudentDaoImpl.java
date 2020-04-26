package org.student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjDoubleConsumer;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

public class StudentDaoImpl implements IStudentDao{//���ݷ��ʲ� : ԭ���Բ��ɲ� ��ɾ�Ĳ�
	
	private final String URL = "jdbc:mysql://localhost:3306/hjc_mysql";
	private final String USER = "root";
	private final String PASSWORD = "hjc290018";
	
	
	//������ڴ������ࣨ�ظ���
	public boolean isExist(int sno) {
		return queryStudentBySno( sno)==null?false:true;
		
		/*�Լ�д����ô��������
		Student student = new Student();
		student = queryStudentBySno( sno);
		if(student==null) {
			return false;
		}else {
			return true;
		}
		*/
	}
	public boolean addstudent(Student student) {
		String sql = "insert into student values(?,?,?,?)";
		Object []params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	
	public boolean deleteStudentBySno(int sno) {  //����ѧ��ɾ��ѧ��
        String sql = "delete from student where sno=?";
        Object []params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public boolean updateStudentBySno(int sno , Student student) {// ����sno�����ҵ��˸ĳ�student
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	}
	//��ȫ��ѧ��
	public List<Student> queryAllStudent() { 
		List<Student> students = new ArrayList<>();//�кܶ�ѧ�� �����ü���
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = null;
		try {
		String sql = "select * from student ";
	    rs = DBUtil.executeQuery(sql, null);
		
		 while(rs.next()) {
			 int no = rs.getInt(1);
			 String name = rs.getString(2);
			 int age = rs.getInt(3);
			 String address = rs.getString(4);
			 student = new Student(no,name,age,address);
			 students.add(student); //���ϵ�֪ʶ ��ÿһλ�ӽ�����
		 }
		 return students;
		 
		
		
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(DBUtil.connection!=null) DBUtil.connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public Student queryStudentBySno(int sno) { //����ѧ�Ų�ѧ��
		Student student = null;
		try {
		String sql = "select * from student where sno=?";
		Object[] params = {sno};
		DBUtil.executeQuery(sql, params);
		 DBUtil.pstmt = DBUtil.connection.prepareStatement(sql);
		 DBUtil.rs = DBUtil.pstmt.executeQuery();
		 if(DBUtil.rs.next()) {
			 int no = DBUtil.rs.getInt(1);
			 String name = DBUtil.rs.getString(2);
			 int age = DBUtil.rs.getInt(3);
			 String address = DBUtil.rs.getString(4);
			 student = new Student(no,name,age,address);
		 }
		 return student;
		 
		
		
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
			if(DBUtil.rs!=null) DBUtil.rs.close();
			if(DBUtil.pstmt!=null) DBUtil.pstmt.close();
			if(DBUtil.connection!=null) DBUtil.connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public int getTotalCount() {//��ѯ��������
		String sql="select count(1) from student";
		return DBUtil.getTotalCount(sql);
	}
	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		String sql="select * from student limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List<Student> students = new ArrayList<>();
		try {
			while(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				Student student = new Student(no,name,age,address);
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rs!=null) rs.close();
			if(DBUtil.rs!=null) DBUtil.rs.close();
			if(DBUtil.pstmt!=null) DBUtil.pstmt.close();
			if(DBUtil.connection!=null) DBUtil.connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return students;
	}

}
