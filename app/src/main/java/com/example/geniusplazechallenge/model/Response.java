package com.example.geniusplazechallenge.model;

import java.util.List;

public class Response{
	private int perPage;
	private int total;
	private List<DataItem> data;
	private int page;
	private int totalPages;

	public int getPerPage(){
		return perPage;
	}

	public int getTotal(){
		return total;
	}

	public List<DataItem> getData(){
		return data;
	}

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"per_page = '" + perPage + '\'' + 
			",total = '" + total + '\'' + 
			",data = '" + data + '\'' + 
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			"}";
		}
}