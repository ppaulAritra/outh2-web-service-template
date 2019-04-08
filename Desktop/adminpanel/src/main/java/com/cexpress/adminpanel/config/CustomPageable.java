package com.cexpress.adminpanel.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"sort"})

public class CustomPageable implements Pageable{

	
	
	private  int pageSize;
	private int pageNumber;
	//private  int offset;
	private boolean paged;
	private boolean unpaged;
	private Sort  sort;
	
	public Sort getSort() {
		List<String> properties = new ArrayList<String>();
		properties.add("false");
		properties.add("true");
		Sort sort = new Sort(null,properties);
		return sort;
	}
	
    public void setSort(Sort sort) {
        this.sort = sort;
    }
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	
	public boolean isPaged() {
		return paged;
	}
	public void setPaged(boolean paged) {
		this.paged = paged;
	}
	public boolean isUnpaged() {
		return unpaged;
	}
	public void setUnpaged(boolean unpaged) {
		this.unpaged = unpaged;
	}
	@Override
	public long getOffset() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pageable previousOrFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pageable first() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
