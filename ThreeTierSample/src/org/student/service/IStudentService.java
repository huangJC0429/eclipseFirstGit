package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	public boolean addstudent(Student student) ;
	//带有逻辑性的删除
	public boolean deleteStudentBySno(int sno);
	//带有逻辑性的修改
	public boolean updateStudentBySno(int sno,Student student) ;
	//根据学号查询一个人 ,查询没有什么逻辑 直接调用即可
	public Student queryStudentBySno(int sno) ;
	public List<Student> queryAllStudent();
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
	public int getTotalCount();

}
