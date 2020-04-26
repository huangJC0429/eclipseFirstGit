package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//ҵ���߼���:�߼��Ե���ɾ�Ĳ�,���������ݷ��ʲ�
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentdao = new StudentDaoImpl();
		public boolean addstudent(Student student) {
			if(!studentdao.isExist(student.getSno())) {//������
				studentdao.addstudent(student);
				return true;
			}else {
				System.out.println("�����Ѵ���!");
				return false;
			}				
		}
		
		//�����߼��Ե�ɾ��
		public boolean deleteStudentBySno(int sno) {
			if(!studentdao.isExist(sno)) {
				return false;
			}else {
				return studentdao.deleteStudentBySno(sno);	
			}
		}
		//�����߼��Ե��޸�
		public boolean updateStudentBySno(int sno,Student student) {
			if(studentdao.isExist(sno)) {
				return studentdao.updateStudentBySno(sno, student);
			}else {
				return false;
			}
		}
		//����ѧ�Ų�ѯһ���� ,��ѯû��ʲô�߼� ֱ�ӵ��ü���
		public Student queryStudentBySno(int sno) {
				return studentdao.queryStudentBySno(sno);
		}
		//��ѯ����ѧ��
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
