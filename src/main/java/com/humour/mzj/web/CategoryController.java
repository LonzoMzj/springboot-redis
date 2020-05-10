package com.humour.mzj.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.humour.mzj.pojo.Category;
import com.humour.mzj.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired CategoryService categoryService;
	
	/**
	 * 	展示商品列表信息
	 * @param m
	 * @return
	 * @throws Exception
	 */
    @GetMapping("/categories")   
    public String listCategory(Model m ) throws Exception {
    	String names ="names";//为了不使redis的key为null
    	List<Category> page =categoryService.selectAll(names); 
    	m.addAttribute("page", page);
        return "listCategory";
    }

    /**
     * 	新增商品
     * @param c
     * @return
     * @throws Exception
     */
	@PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
    	categoryService.save(c);
    	return "redirect:/categories";
    }
	/**
	 * 	删除商品
	 * @param c
	 * @return
	 * @throws Exception
	 */
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
    	categoryService.delete(c.getId());
    	return "redirect:/categories";
    }
    /**
     * 	保存商品信息
     * @param c
     * @return
     * @throws Exception
     */	
    @PutMapping("/categories/{id}")
    public String updateCategory(Category c) throws Exception {
    	categoryService.updateC(c);
    	return "redirect:/categories";
    }
    /**
     *	 查询单个商品，跳转至编辑页面
     * @param id
     * @param m
     * @return
     * @throws Exception
     */
    @GetMapping("/categories/{id}")
    public String ediitCategory(Category c,Model m) throws Exception {
    	Category cs= categoryService.get(String.valueOf(c.getId()));
    	//不知道为啥总报类型转化异常，应该是redis没有int类型的原因，暂不知道怎么解决，现先转化为string
    	m.addAttribute("c", cs);
    	return "editCategory";
    }
}

