package com.atguigu.jdbc.whc.po;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * 
 * @author jxy
 *
 * @param <T>
 */
public class PageBean<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	private long total;   //总记录数
	private List<T> list;  //结果集
	private int pageNum; //第几页
	private int pageSize;// 每页记录数
	private int pages;  //总页数
	private int size;  //当前页的数量 <= pageSize，该属性来自ArrayList的size属性
	
	/**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param list          page结果
     * @param navigatePages 页码数量
     */
	public PageBean(List<T> list) {
		if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
        }else {
        	this.list = list;
        }		
	}
	
	
	
	public PageBean(long total, List<T> list, int pageNum, int pageSize, int pages, int size) {
		this.total = total;
		this.list = list;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pages = pages;
		this.size = size;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "PageBean [total=" + total + ", list=" + list + ", pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", pages=" + pages + ", size=" + size + "]";
	}
	
}












