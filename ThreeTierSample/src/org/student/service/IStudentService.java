package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	public boolean addstudent(Student student) ;
	//�����߼��Ե�ɾ��
	public boolean deleteStudentBySno(int sno);
	//�����߼��Ե��޸�
	public boolean updateStudentBySno(int sno,Student student) ;
	//����ѧ�Ų�ѯһ���� ,��ѯû��ʲô�߼� ֱ�ӵ��ü���
	public Student queryStudentBySno(int sno) ;
	public List<Student> queryAllStudent();
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
	public int getTotalCount();

}
