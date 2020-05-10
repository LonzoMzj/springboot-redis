package com.humour.mzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.humour.mzj.pojo.Category;
@Mapper
public interface CategoryDaoMapper {

	List<Category> selectAll();

	void save(Category category);

	void delete(int id);

	Category findOne(String id);

	void updateC(Category c);
	
}
