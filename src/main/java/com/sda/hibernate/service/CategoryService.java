package com.sda.hibernate.service;

import com.sda.hibernate.dao.CategoryDao;
import com.sda.hibernate.entity.Category;

import java.util.List;

public class CategoryService {

    private static CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }

    public void save (Category category){
        categoryDao.openCurrentSession();
        categoryDao.save(category);
        categoryDao.closeCurrentSession();
    }

    public void update(Category category){
        categoryDao.openCurrentSession();
        categoryDao.update(category);
        categoryDao.closeCurrentSession();
    }

    public Category findById(int id){
        categoryDao.openCurrentSession();
        Category category = categoryDao.findById(id);
        categoryDao.closeCurrentSession();
        return category;
    }

    public void delete(int id){
        categoryDao.openCurrentSession();
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        categoryDao.closeCurrentSession();
    }

    public void deleteAll(){
        categoryDao.openCurrentSession();
        categoryDao.deleteAll();
        categoryDao.closeCurrentSession();
    }

    public List<Category> findAll(){
        categoryDao.openCurrentSession();
        List<Category> categoryList = categoryDao.findAll();
        categoryDao.closeCurrentSession();
        return  categoryList;
    }

}
