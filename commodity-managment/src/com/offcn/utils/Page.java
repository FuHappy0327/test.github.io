package com.offcn.utils;

import java.util.List;

public class Page<T> {

	private List<T> list; // 每页查询出来的数据存放的集合
	public int pageSize = 4; // 每页显示的记录数
	private int pageNo; // 当前页，通过用户传入
//	private int totalPageNo; // 总页数，通过计算得到
	private int totalRecord; // 总记录数，通过查询数据库得到


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNo() {
		if (pageNo <= 1) {
			// 如果当前页码小于1，直接返回1
			return 1;
		} else if (pageNo > getTotalPageNo()) {
			// 如果当前页码大于总页数，返回总页数
			return getTotalPageNo();
		} else {
			return pageNo;
		}
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	//如果计算总页数，必须知道总数据量为多少，才能计算
	// 总页数是由总记录数和每页显示的条数计算得到
	public int getTotalPageNo() {
		if (totalRecord % pageSize == 0) {
			return totalRecord / pageSize;
		} else {
			return totalRecord / pageSize + 1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
