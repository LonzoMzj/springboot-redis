package com.humour.mzj.service;

import java.util.List;

import com.humour.mzj.pojo.Category;

public interface CategoryService {
	
	public void save(Category category);
	
	public void delete(int id);
	
	public Category get(String id);

	public List<Category> selectAll(String names);

	public void updateC(Category c);
}
