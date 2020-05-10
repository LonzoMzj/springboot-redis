package com.humour.mzj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.humour.mzj.dao.CategoryDaoMapper;
import com.humour.mzj.pojo.Category;
import com.humour.mzj.service.CategoryService;

@Service
@CacheConfig(cacheNames = "category")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDaoMapper mapper;

	@Override
	@Cacheable(value = "category", key = "#names")
	public List<Category> selectAll(String names) {
		List<Category> list = mapper.selectAll();
		System.out.println("查询数据库了");
		return list;
	}

	@Override
	@Cacheable(key = "#id")
	public Category get(String id) {
		Category c = mapper.findOne(id);
		return c;
	}

	@Override
	@CacheEvict(allEntries = true)
//	@CachePut(key="'category '+ #p0")
	public void save(Category category) {

		mapper.save(category);
	}

	@Override
	@CacheEvict(allEntries = true)
//	@CacheEvict(key="'category '+ #p0")	
	public void delete(int id) {
		mapper.delete(id);
	}

	@Override
	@CacheEvict(allEntries = true)
	public void updateC(Category c) {
		mapper.updateC(c);

	}

}
