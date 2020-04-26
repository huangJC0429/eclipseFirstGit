package org.student.entity;

import java.util.List;

//分页的帮助类
public class Page {
	//当前页
	private int currentPage;
	//页面大小
	private int pageSize;
	//总数据
	private int totalCount;
	//总页数
	private int totalPage;
	//当前页的学生数据
	private List<Student> students;
	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Student> students) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	/*
	 * 总页数 = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1 ;
	 * 
	 * 当我们调换用了 数据总数的set() 和 页面大小的set()以后，自动计算出 总页数
	 * 务必注意顺序：先set 数据总数   再set 页面大小
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
//		总页数 = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1 ;
		this.totalPage =this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:totalCount/this.pageSize+1; 
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	//public void setTotalPage(int totalPage) {
	//	this.totalPage = totalPage;
	//}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Page() {
		
	}
}
	
