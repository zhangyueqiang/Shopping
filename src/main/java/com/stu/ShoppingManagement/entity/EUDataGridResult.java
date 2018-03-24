package com.stu.ShoppingManagement.entity;

import java.util.List;


/*
	Easy UI用来分页的实体类

 */
public class EUDataGridResult{



	private long total;
	private List<?> rows;	//问号表示可以加任何类型,就不用制定一个泛型T了
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}