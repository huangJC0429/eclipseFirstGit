package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//业务逻辑层:逻辑性的增删改查,依赖于数据访问层
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentdao = new StudentDaoImpl();
		public boolean addstudent(Student student) {
			if(!studentdao.isExist(student.getSno())) {//不存在
				studentdao.addstudent(student);
				return true;
			}else {
				System.out.println("此人已存在!");
				return false;
			}				
		}
		
		//带有逻辑性的删除
		public boolean deleteStudentBySno(int sno) {
			if(!studentdao.isExist(sno)) {
				return false;
			}else {
				return studentdao.deleteStudentBySno(sno);	
			}
		}
		//带有逻辑性的修改
		public boolean updateStudentBySno(int sno,Student student) {
			if(studentdao.isExist(sno)) {
				return studentdao.updateStudentBySno(sno, student);
			}else {
				return false;
			}
		}
		//根据学号查询一个人 ,查询没有什么逻辑 直接调用即可
		public Student queryStudentBySno(int sno) {
				return studentdao.queryStudentBySno(sno);
		}
		//查询所有学生
		public List<Student> queryAllStudent(){
			return studentdao.queryAllStudent();
		}

		@Override
		public List<Student> queryStudentByPage(int currentPage, int pageSize) {
			
			return studentdao.queryStudentByPage(currentPage, pageSize);
		}

		@Override
		public int getTotalCount() {
			
			return studentdao.getTotalCount();
		}
		
		
		
		
}
