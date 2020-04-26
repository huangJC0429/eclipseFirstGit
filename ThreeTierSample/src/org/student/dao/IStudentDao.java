package org.student.dao;


import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	public boolean isExist(int sno);
	public boolean addstudent(Student student);
	public boolean deleteStudentBySno(int sno);
	public boolean updateStudentBySno(int sno , Student student);
	public List<Student> queryAllStudent();
	public Student queryStudentBySno(int sno) ;
	public int getTotalCount();
	public List<Student> queryStudentByPage(int currentPage,int pageSize );

}
